/**
 * MIT License
 *
 * Copyright (c) 2017 Tomasz Bawor
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.tbawor.jrogal.ui.creator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * Controller for PlayerCreator scene.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class PlayerCreator implements Initializable {

    /**
     * Starting skillpoints to redistribute.
     */
    private static final int POINTS_TO_SPEND = 20;

    /**
     * Reference to text field with name.
     * @checkstyle MemberNameCheck (3 line)
     */
    @FXML
    private TextField inputName;

    /**
     * Reference to label with remaining points to spend.
     * @checkstyle MemberNameCheck (4 line)
     */
    @FXML
    private Label pointsToSpend;

    /**
     * Reference to slider indicating player strength.
     * @checkstyle MemberNameCheck (3 line)
     */
    @FXML
    private Slider strengthSlider;

    /**
     * Reference to slider indicating player strength.
     * @checkstyle MemberNameCheck (3 line)
     */
    @FXML
    private Slider defenceSlider;

    @Override
    public final void initialize(final URL location,
        final ResourceBundle resources) {
        this.pointsToSpend
            .setText(
                String.valueOf(PlayerCreator.POINTS_TO_SPEND)
        );
        this.initDefenceNormalization();
        this.initStrengthNormalization();
        this.initRemainingPointsChanger();
    }

    /**
     * Method binded to start button click.
     */
    @FXML
    public final void startGame() {
        this.pointsToSpend.setText(
            String.format("Welcome %s!", this.inputName.getText())
        );
    }

    /**
     * Initializing listener changing strength value when defence is slided.
     */
    private void initStrengthNormalization() {
        this.defenceSlider.valueProperty().addListener(
            (observable, old, current) -> {
                final double strength = this.strengthSlider.getValue();
                final double spend = strength + current.doubleValue();
                if (spend > PlayerCreator.POINTS_TO_SPEND) {
                    this.strengthSlider.setValue(
                        PlayerCreator.POINTS_TO_SPEND - current.intValue()
                    );
                }
            }
        );
    }

    /**
     * Initializing listener changing defence value when strength is slided.
     */
    private void initDefenceNormalization() {
        this.strengthSlider.valueProperty().addListener(
            (observable, old, current) -> {
                final double defence = this.defenceSlider.getValue();
                final double used = defence + current.doubleValue();
                if (used > PlayerCreator.POINTS_TO_SPEND) {
                    this.defenceSlider.setValue(
                        PlayerCreator.POINTS_TO_SPEND - current.intValue()
                    );
                }
            }
        );
    }

    /**
     * Function adding callback to update remaining points indicator.
     */
    private void initRemainingPointsChanger() {
        final ChangeListener<? super Number> updater =
            (observable, old, value) -> {
                final int spend = this.strengthValue() + this.defenceValue();
                this.pointsToSpend.setText(
                    String.valueOf(PlayerCreator.POINTS_TO_SPEND - spend)
                );
            };
        this.strengthSlider.valueProperty().addListener(updater);
        this.defenceSlider.valueProperty().addListener(updater);
    }

    /**
     * Function reading defence slider  value.
     * @return Defence int value
     */
    private int defenceValue() {
        return (int) this.defenceSlider.getValue();
    }

    /**
     * Function reading strength slider value.
     * @return Strength int value
     */
    private int strengthValue() {
        return (int) this.strengthSlider.getValue();
    }

}
