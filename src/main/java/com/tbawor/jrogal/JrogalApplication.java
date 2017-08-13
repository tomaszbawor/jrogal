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
package com.tbawor.jrogal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main class of JRogal Application with entry point to application.
 *
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class JrogalApplication extends Application {

    /**
     * Width of main window.
     */
    private static final int WIDTH = 300;

    /**
     * Height of main window.
     */
    private static final int HEIGHT = 500;

    /**
     * Main method.
     * @param args Command line arguments
     */
    public static void main(final String... args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        final StackPane root = new StackPane();
        final Scene scene = new Scene(
            root,
            JrogalApplication.WIDTH,
            JrogalApplication.HEIGHT
        );
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }
}
