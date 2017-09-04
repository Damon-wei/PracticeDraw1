package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();
    Path path = new Path();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawPath() 方法画心形
      /*
        Path一共有两大类方法

            一：直接描述路径

                第一组：addXxx() ——添加子图形
                    addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆
                    addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形
                    addRoundRect(RectF rect, float rx, float ry, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir) / addRoundRect(RectF rect, float[] radii, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形
                    addPath(Path path) 添加另一个 Path

                第二组：xxxTo() ——画线（直线或曲线）
                    lineTo(float x, float y) / rLineTo(float x, float y) 画直线。前者是绝对位置，后者是相对位置
                    quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
                    cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) / rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) 画三次贝塞尔曲线
                    moveTo(float x, float y) / rMoveTo(float x, float y) 移动到目标位置
                    arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
                        这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
                        少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；
                        而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
                        addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo() 。
                    close() 封闭当前子图形

            二：辅助的设置或计算

                Path.setFillType(Path.FillType ft) 设置填充方式
                    FillType 的取值有四个：
                        EVEN_ODD
                        WINDING （默认值）
                        INVERSE_EVEN_ODD
                        INVERSE_WINDING
                    其中后面的两个带有 INVERSE_ 前缀的，只是前两个的反色版本
                    简单粗暴版的总结： WINDING 是「全填充」，而 EVEN_ODD 是「交叉填充」：

        */
        //path.addCircle(100,100,100,Path.Direction.CW);
        //path.addCircle(300,100,100,Path.Direction.CW);
        //path.addArc(0,0,200,200,-90,180);
        path.addArc(0,200,200,400,-225,225);
        path.arcTo(200,200,400,400,-180,225,false);
        path.lineTo(200,550);
        canvas.drawPath(path,paint);
    }
}
