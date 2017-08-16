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
package com.tbawor.jrogal.ui.menu;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Controller for application main menu.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class MenuController {

    /**
     * Reference to start button.
     * @checkstyle MemberNameCheck (3 line)
     */
    @FXML
    private Button startButton;

    /**
     * Function executed when Start button is pressed in main menu.
     * @throws IOException when invalid fxml url provided.
     * @checkstyle NonStaticMethodCheck (3 lines)
     */
    public void onStartClicked() throws IOException {
        final Parent root = FXMLLoader
            .load(
                getClass()
                    .getResource("../creator/creator.fxml")
            );
        final Scene scene = new Scene(root);
        this.setNewScene(scene);
    }

    /**
     * Function executed when Exit button pressed in main menu.
     * @checkstyle NonStaticMethodCheck (3 lines)
     */
    public void onExitClicked() {
        Platform.exit();
    }

    /**
     * Sets new javafx scene.
     * @param scene New scene object
     */
    private void setNewScene(final Scene scene) {
        final Window window = this.startButton.getScene().getWindow();
        if (window instanceof Stage) {
            final Stage stage = (Stage) window;
            stage.setScene(scene);
        }
    }

}
