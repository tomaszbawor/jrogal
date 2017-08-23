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
package com.tbawor.jrogal.game.map;

/**
 * Game level map.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class GameLevel {

    /**
     * Two dimensional map of tiles.
     */
    private final Tile[][] tiles;

    /**
     * Default constructor.
     * @param width Width of the map
     * @param height Height of the map
     */
    GameLevel(final int width, final int height) {
        this.tiles = initializeEmptyTiles(width, height);
    }

    /**
     * Method returning tile at given position.
     * @param xpos X position.
     * @param ypos Y position.
     * @return Tile at given position.
     */
    public final Tile getTile(final int xpos, final int ypos) {
        return this.tiles[xpos][ypos];
    }

    /**
     * Static method initializing empty map.
     * @param width Width of the map
     * @param height Height of the map
     * @return Two dimensional array of map tiles
     */
    private static Tile[][] initializeEmptyTiles(
        final int width,
        final int height
    ) {
        final Tile[][] tiles = new Tile[width][height];
        for (int xpos = 0; xpos < width; xpos = xpos + 1) {
            for (int ypos = 0; ypos < height; ypos = ypos + 1) {
                tiles[xpos][ypos] = Tile.FLOOR;
            }
        }
        return tiles;
    }
}
