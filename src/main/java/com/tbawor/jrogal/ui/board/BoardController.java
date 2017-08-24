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
package com.tbawor.jrogal.ui.board;

import com.tbawor.jrogal.game.map.GameLevel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Controller for Game board scene.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class BoardController implements Initializable {

    /**
     * Map width in tiles.
     */
    private static final int MAP_WIDTH_TILES = 10;

    /**
     * Map height it tiles.
     */
    private static final int MAP_HEIGHT_TILES = 10;

    /**
     * Canvas representing game map.
     */
    @FXML
    private Canvas map;

    @Override
    public final void initialize(final URL location,
        final ResourceBundle resources) {
        this.map.setFocusTraversable(true);
        final GameLevel level = new GameLevel(
            BoardController.MAP_WIDTH_TILES,
            BoardController.MAP_HEIGHT_TILES
        );
        final MapRenderer renderer = new MapRenderer(level, this.map);
        renderer.render();
    }

    /**
     * Method for handling arrow keys for moving on map.
     * @param event Key pressed event
     */
    @FXML
    public final void handleKey(final KeyEvent event) {
        final KeyCode code = event.getCode();
        if (code.isArrowKey()) {
            final double position = 10.0d;
            this.map.getGraphicsContext2D()
                .fillText("Arrow Pressed", position, position);
        }
    }
}
