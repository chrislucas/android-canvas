package br.com.xplore.drawgraph.customview;

import android.graphics.Point;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;

public class SaveStateTrigonometryCustomView extends View.BaseSavedState {

    private Point point;

    public SaveStateTrigonometryCustomView(Parcel source) {
        super(source);
        this.point = (Point) source.readValue(Point.class.getClassLoader());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public SaveStateTrigonometryCustomView(Parcel source, ClassLoader loader) {
        super(source, loader);
    }

    public SaveStateTrigonometryCustomView(Parcelable superState) {
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeValue(this.point);
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }


    public static final Parcelable.Creator<SaveStateTrigonometryCustomView> CREATOR
            = new Parcelable.Creator<SaveStateTrigonometryCustomView>() {
        @Override
        public SaveStateTrigonometryCustomView createFromParcel(Parcel source) {
            return new SaveStateTrigonometryCustomView(source);
        }

        @Override
        public SaveStateTrigonometryCustomView[] newArray(int size) {
            return new SaveStateTrigonometryCustomView[size];
        }
    };

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
