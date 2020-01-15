package com.raywenderlich.facespotter;

import android.graphics.PointF;

public class Eyes {

    private static Eyes mInstance;

    private final float eulerMultiplyFactor = 2.3f;
    private final float eyeWidthExtensionValue = 40;
    private final float eyeHeightExtensionValue = 80;

    private PointF leftEyePosition;
    private PointF rightEyePosition;

    private float eyeRadius;
    private float eulerZ;



    private Eyes() { }

    public static Eyes newInstance(PointF leftEyePosition, PointF rightEyePosition, float eyeRadius, float eulerZ) {
        if (mInstance == null) {
            mInstance = new Eyes();
        }
        mInstance.leftEyePosition = leftEyePosition;
        mInstance.rightEyePosition = rightEyePosition;
        mInstance.eyeRadius = eyeRadius;
        mInstance.eulerZ = eulerZ;
        return mInstance;
    }

    public int getLeft() { return (int) (leftEyePosition.x - getEyeWidthRadius()); }

    public int getRight() { return (int) (rightEyePosition.x + getEyeWidthRadius()); }

    public int getTop() {
        if (eulerZ > 0) return (int) (leftEyePosition.y - getEyeHeightRadius());
        else return (int) (rightEyePosition.y - getEyeHeightRadius());
    }

    public int getBottom() {
        if (eulerZ > 0) return (int) (rightEyePosition.y + getEyeHeightRadius());
        else return (int) (leftEyePosition.y + getEyeHeightRadius());
    }

    public int getWidth(){ return getRight()- getLeft(); }

    public int getHeight (){ return getBottom() - getTop(); }

    public float getEuleredLeft() { return getLeft() - (getAbsoluteEulerZ() * eulerMultiplyFactor); }

    public float getEuleredTop() { return getTop() - (getAbsoluteEulerZ() * eulerMultiplyFactor); }

    public float getEulerZ() { return eulerZ; }

    public float getAbsoluteEulerZ() { return Math.abs(eulerZ); }

    public float getEyeWidthRadius() { return eyeRadius + eyeWidthExtensionValue; }

    public float getEyeHeightRadius() { return eyeRadius + eyeHeightExtensionValue - getAbsoluteEulerZ(); }


}
