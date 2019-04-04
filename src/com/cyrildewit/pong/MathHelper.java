package com.cyrildewit.pong;

/**
 * @see https://github.com/pacampbell/Game/blob/master/src/game/framework/MathHelper.java
 */
public class MathHelper {

    /**
     * Clamps a float between a min and a max value. <br>
     *
     * If the value is below min, value is set to min. <br>
     * If the value is above max, value is set to max. <br>
     * If the value is min < value < max then we leave it alone. <br>
     *
     * @param  value  Value to be clamped.
     * @param  min  Minimum value the value can be.
     * @param  max  Minimum value the value can be.
     * @return Returns the clamped value.
     */
	public static float clamp(float value, float min, float max) {
		return (value > max) ? max : (value < min) ? min : value;
    }

    /**
     * Clamps a integer between a min and a max value. <br>
     *
     * If the value is below min, value is set to min. <br>
     * If the value is above max, value is set to max. <br>
     * If the value is min < value < max then we leave it alone. <br>
     *
     * @param  value  Value to be clamped.
     * @param  min  Minimum value the value can be.
     * @param  max  Minimum value the value can be.
     * @return Returns the clamped value.
     */
	public static int clamp(int value, int min, int max) {
		return (value > max) ? max : (value < min) ? min : value;
    }

}
