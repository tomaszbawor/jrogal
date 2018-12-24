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

import javafx.scene.image.Image;

/**
 * Controller for Game board scene.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public enum BoardTile {

    /**
     * Floor tile, currently grass.
     */
    FLOOR("/tiles/grass/grass0.png"),

    /**
     * Wall tile.
     */
    WALL("/tiles/walls/brick_brown0.png"),

    /**
     * Door tile.
     */
    DOOR("/tiles/door.jpg");

    /**
     * Tile image to display.
     */
    private final Image image;

    /**
     * Constructor for enum.
     * @param url Url to tile image
     */
    BoardTile(final String url) {
        this.image = new Image(getClass().getResource(url).toString());
    }

    /**
     * Getter for Image object for proper tile.
     * @return Image of tile
     */
    public Image getImage() {
        return this.image;
    }
}
