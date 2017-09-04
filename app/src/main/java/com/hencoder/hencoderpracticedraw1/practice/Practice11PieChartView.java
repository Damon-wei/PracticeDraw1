package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class Practice11PieChartView extends View {

    private String[] s = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private Integer[] percent = {2, 8, 10, 50, 80, 160, 50};
    private Integer[] color = {Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.LTGRAY, Color.YELLOW};


    List<String> deviceNames;//名字
    List<Integer> colorInteger;//颜色
    List<Integer> precentInteger;//百分比

    Paint paintPie;//画饼
    Paint paintText;//画字体
    Paint paintLine;//画线

    RectF rectfCommon;//不移动的部分
    RectF rectfMove;//移动的部分

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    private void init() {
        deviceNames = Arrays.asList(s);
        colorInteger = Arrays.asList(color);
        precentInteger = Arrays.asList(percent);

        paintPie = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLine.setStrokeWidth(5);
        paintLine.setColor(Color.LTGRAY);

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setTextSize(30);
        paintText.setColor(Color.LTGRAY);

        rectfCommon = new RectF(-300, -300, 300, 300);
        rectfMove = new RectF(-330, -330, 280, 280);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int width = getWidth();
        int height = getHeight();

        canvas.translate(width/2,height/2);
        float startAngle = 0;
        float sweepAngle = 0;
        for (int i = 0; i < deviceNames.size(); i++) {
            //画饼
            paintPie.setColor(colorInteger.get(i));
            sweepAngle = precentInteger.get(i);
            float textAngle = startAngle + precentInteger.get(i) / 2;

            //第五个饼会离开一段距离
            if (i == 5) {
                canvas.drawArc(rectfMove, startAngle + 1, sweepAngle - 1, true, paintPie);
            } else {
                canvas.drawArc(rectfCommon, startAngle + 1, sweepAngle - 1, true, paintPie);
            }

            //初始化每个饼的起始角度
            startAngle = startAngle + sweepAngle;
        }

    }
}
