package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        devices = Arrays.asList(name);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private Paint paint;
    private String[] name = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private List<String> devices;
    private int width = 20;//柱状图间距
    private int textY = 540;//绘制字体的纵坐标
    private int lineY = 500;//绘制底线的纵坐标
    private int offset = 180;//开始画第一个柱的位置

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLine(100,0,100,500,paint);
        canvas.drawLine(100,500,1000,500,paint);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(100);

        for (int i = 0; i < devices.size(); i++) {
            //绘制柱状图
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(100);
            canvas.drawLine(offset + (100+width) * i,lineY,offset + (100+width) * i,400 - (71 * i),paint);

            //绘制文字
            paint.setTextSize(30);
            paint.setColor(Color.WHITE);
            Rect mBound = new Rect();
            paint.getTextBounds(devices.get(i), 0, devices.get(i).length(), mBound);
            canvas.drawText(devices.get(i),offset + (100+width) * i - mBound.width() / 2,textY,paint);
        }
    }
}
