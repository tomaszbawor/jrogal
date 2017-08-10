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

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Tests for application entry point.
 *
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @checkstyle MethodBodyComments (500 lines)
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public final class JrogalApplicationTest {

    @Test
    public void shouldDoNothing() throws Exception {
        // given
        final String[] arguments = new String[]{"First", "Second"};
        // when
        JrogalApplication.main(arguments);
        // then
        Assertions.assertThat(arguments).isNotEmpty();
    }

    @Test
    public void shouldHaveOnlyPrivateConstructors() throws Exception {
        // given
        final Constructor<?>[] constructors =
            JrogalApplication.class.getDeclaredConstructors();
        // then
        for (final Constructor<?> constructor : constructors) {
            Assertions.assertThat(
                Modifier.isPrivate(
                    constructor.getModifiers()
                )
            ).isTrue();
        }
        // covering constructor
        constructors[0].setAccessible(true);
        constructors[0].newInstance((Object[]) null);
    }
}