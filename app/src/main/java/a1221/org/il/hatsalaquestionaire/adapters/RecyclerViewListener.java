package a1221.org.il.hatsalaquestionaire.adapters;


import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Daniel on 12/27/2016.
 */

public class RecyclerViewListener extends RecyclerView.SimpleOnItemTouchListener {

    private static final String TAG = "LanguageRecyclerViewLis";

    public interface OnRecyclerClickListener {
        void onitemClick(View v, int position);

    }

    private final OnRecyclerClickListener mListener;
    private final GestureDetectorCompat mGestureDetector;

    public RecyclerViewListener(Context context, final RecyclerView recyclerView, final OnRecyclerClickListener mListener) {
        this.mListener = mListener;
        mGestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG, "onSingleTapUp: starts");
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && mListener != null) {
                    mListener.onitemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
                return true;
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.d(TAG, "onInterceptTouchEvent: starts");
        if (mGestureDetector != null) {
            boolean result = mGestureDetector.onTouchEvent(e);
            return result;
        } else {
            return false;
        }

    }
}
