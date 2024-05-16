package com.google.android.material.color;

final class ViewingConditions {
    public static final ViewingConditions DEFAULT = make(ColorUtils.whitePointD65(), (float) ((((double) ColorUtils.yFromLstar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float aw;
    private final float c;
    private final float fl;
    private final float flRoot;
    private final float n;
    private final float nbb;
    private final float nc;
    private final float ncb;
    private final float[] rgbD;
    private final float z;

    public float getAw() {
        return this.aw;
    }

    public float getN() {
        return this.n;
    }

    public float getNbb() {
        return this.nbb;
    }

    /* access modifiers changed from: package-private */
    public float getNcb() {
        return this.ncb;
    }

    /* access modifiers changed from: package-private */
    public float getC() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public float getNc() {
        return this.nc;
    }

    public float[] getRgbD() {
        return this.rgbD;
    }

    /* access modifiers changed from: package-private */
    public float getFl() {
        return this.fl;
    }

    public float getFlRoot() {
        return this.flRoot;
    }

    /* access modifiers changed from: package-private */
    public float getZ() {
        return this.z;
    }

    static ViewingConditions make(float[] whitePoint, float adaptingLuminance, float backgroundLstar, float surround, boolean discountingIlluminant) {
        float c2;
        float d;
        float f = adaptingLuminance;
        float[][] matrix = Cam16.XYZ_TO_CAM16RGB;
        float[] xyz = whitePoint;
        float rW = (xyz[0] * matrix[0][0]) + (xyz[1] * matrix[0][1]) + (xyz[2] * matrix[0][2]);
        float gW = (xyz[0] * matrix[1][0]) + (xyz[1] * matrix[1][1]) + (xyz[2] * matrix[1][2]);
        float bW = (xyz[0] * matrix[2][0]) + (xyz[1] * matrix[2][1]) + (xyz[2] * matrix[2][2]);
        float f2 = (surround / 10.0f) + 0.8f;
        if (((double) f2) >= 0.9d) {
            c2 = MathUtils.lerp(0.59f, 0.69f, (f2 - 0.9f) * 10.0f);
        } else {
            c2 = MathUtils.lerp(0.525f, 0.59f, (f2 - 0.8f) * 10.0f);
        }
        if (discountingIlluminant) {
            d = 1.0f;
        } else {
            d = (1.0f - (((float) Math.exp((double) (((-f) - 42.0f) / 92.0f))) * 0.2777778f)) * f2;
        }
        float d2 = ((double) d) > 1.0d ? 1.0f : ((double) d) < 0.0d ? 0.0f : d;
        float[] rgbD2 = {(((100.0f / rW) * d2) + 1.0f) - d2, (((100.0f / gW) * d2) + 1.0f) - d2, (((100.0f / bW) * d2) + 1.0f) - d2};
        float k = 1.0f / ((5.0f * f) + 1.0f);
        float k4 = k * k * k * k;
        float k4F = 1.0f - k4;
        float gW2 = gW;
        float fl2 = (k4 * f) + (0.1f * k4F * k4F * ((float) Math.cbrt(((double) f) * 5.0d)));
        float n2 = ColorUtils.yFromLstar(backgroundLstar) / whitePoint[1];
        float z2 = ((float) Math.sqrt((double) n2)) + 1.48f;
        float fl3 = fl2;
        float nbb2 = 0.725f / ((float) Math.pow((double) n2, 0.2d));
        float ncb2 = nbb2;
        float f3 = rW;
        float[] rgbAFactors = {(float) Math.pow(((double) ((rgbD2[0] * fl3) * rW)) / 100.0d, 0.42d), (float) Math.pow(((double) ((rgbD2[1] * fl3) * gW2)) / 100.0d, 0.42d), (float) Math.pow(((double) ((rgbD2[2] * fl3) * bW)) / 100.0d, 0.42d)};
        float[] rgbA = {(rgbAFactors[0] * 400.0f) / (rgbAFactors[0] + 27.13f), (rgbAFactors[1] * 400.0f) / (rgbAFactors[1] + 27.13f), (rgbAFactors[2] * 400.0f) / (rgbAFactors[2] + 27.13f)};
        float fl4 = fl3;
        float[][] fArr = matrix;
        return new ViewingConditions(n2, ((rgbA[0] * 2.0f) + rgbA[1] + (rgbA[2] * 0.05f)) * nbb2, nbb2, ncb2, c2, f2, rgbD2, fl4, (float) Math.pow((double) fl4, 0.25d), z2);
    }

    private ViewingConditions(float n2, float aw2, float nbb2, float ncb2, float c2, float nc2, float[] rgbD2, float fl2, float flRoot2, float z2) {
        this.n = n2;
        this.aw = aw2;
        this.nbb = nbb2;
        this.ncb = ncb2;
        this.c = c2;
        this.nc = nc2;
        this.rgbD = rgbD2;
        this.fl = fl2;
        this.flRoot = flRoot2;
        this.z = z2;
    }
}
