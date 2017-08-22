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

package com.tbawor.jrogal.game.hero;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test for health class.
 *
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @checkstyle MethodBodyComments (500 lines)
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public class HealthTest {
    /**
     * Attack value for stub statistics.
     */
    private static final int ATTACK_VALUE = 10;

    /**
     * Defence value for stub statistics.
     */
    private static final int DEFENCE_VALUE = 4;

    /**
     * Stub statistic for health testing.
     */
    private static final Statistics MOCK_STATISTICS =
        new Statistics(HealthTest.ATTACK_VALUE, HealthTest.DEFENCE_VALUE);

    @Test
    public final void shouldProperlyInitializeHealthFromStatistics() {
        // when
        final int expected = HealthTest.DEFENCE_VALUE * 2;
        final Health health = new Health(HealthTest.MOCK_STATISTICS);
        // then
        Assertions.assertThat(health.getMaximumHealth()).isEqualTo(expected);
        Assertions.assertThat(health.getCurrentValue()).isEqualTo(expected);
    }

    @Test
    public final void shouldReturnProperlyDamagedHealth() {
        // given
        final int damage = 3;
        final Health health = new Health(HealthTest.MOCK_STATISTICS);
        // when
        final Health damaged = health.damage(damage);
        // then
        Assertions.assertThat(damaged.getMaximumHealth())
            .isEqualTo(health.getMaximumHealth());
        Assertions.assertThat(damaged.getCurrentValue())
            .isEqualTo(health.getCurrentValue() - damage);
    }

    @Test
    public final void shouldNotBeDamagedBeyondZero() {
        // given
        final int damage = 10;
        final int defence = 1;
        final Health health = new Health(
            new Statistics(
                HealthTest.ATTACK_VALUE,
                defence
            )
        );
        // when
        final Health damaged = health.damage(damage);
        // then
        Assertions.assertThat(damaged.getCurrentValue()).isZero();
    }

    @Test
    public final void shouldNotHealBeyondMaximumValue() {
        // given
        final int healing = 10;
        final Health health = new Health(HealthTest.MOCK_STATISTICS);
        // when
        final Health healed = health.heal(healing);
        // then
        Assertions
            .assertThat(healed.getCurrentValue())
            .isLessThanOrEqualTo(healed.getMaximumHealth());
    }

}
