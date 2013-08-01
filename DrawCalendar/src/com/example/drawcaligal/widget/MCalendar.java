package com.example.drawcaligal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MCalendar extends View {
	private int screenWidth;
	private int screenHeight;
	private float lineWidth;
	private Paint paint = null;
	public MCalendar(Context context, int width, int height) {
		super(context);
		screenWidth = width;
		screenHeight = height;
	}

	private MCalendar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	private MCalendar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(screenWidth, screenHeight);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float itemWidth = (screenWidth - lineWidth * 8)/7f;
		float itemHeight = (screenHeight - lineWidth * 6)/7f;
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTextSize(3);
		lineWidth = paint.getStrokeWidth();//线的宽度
		paint.setColor(Color.RED);
		//8条竖线
		canvas.drawLine(0, 0, lineWidth, screenHeight, paint);
		canvas.drawLine(itemWidth + lineWidth, 0, itemWidth+2*lineWidth, screenHeight, paint);
		canvas.drawLine(2*lineWidth + 2*itemWidth, 0, 2*itemWidth+3*lineWidth, screenHeight, paint);
		canvas.drawLine(3*lineWidth + 3*itemWidth, 0, 3*itemWidth+4*lineWidth, screenHeight, paint);
		canvas.drawLine(4*lineWidth + 4*itemWidth, 0, 4*itemWidth+5*lineWidth, screenHeight, paint);
		canvas.drawLine(5*lineWidth + 5*itemWidth, 0, 5*itemWidth+6*lineWidth, screenHeight, paint);
		canvas.drawLine(6*lineWidth + 6*itemWidth, 0, 6*itemWidth+7*lineWidth, screenHeight, paint);
		canvas.drawLine(7*lineWidth + 7*itemWidth, 0, 7*itemWidth+8*lineWidth, screenHeight, paint);
		//6条横线
		canvas.drawLine(0, 0, screenWidth, 0, paint);
		canvas.drawLine(0,itemHeight + lineWidth, screenWidth, itemHeight + lineWidth , paint);
		canvas.drawLine(0,2*itemHeight + 2*lineWidth, screenWidth, 2*itemHeight + 3*lineWidth, paint);
		canvas.drawLine(0,3*itemHeight + 3*lineWidth, screenWidth, 3*itemHeight + 4*lineWidth, paint);
		canvas.drawLine(0,4*itemHeight + 4*lineWidth, screenWidth, 4*itemHeight + 5*lineWidth, paint);
		canvas.drawLine(0,5*itemHeight + 5*lineWidth, screenWidth, 5*itemHeight + 6*lineWidth, paint);
		//绘制文字
		paint.setColor(Color.BLACK);
		paint.setTextSize(20);
		float textWidth = paint.measureText("1");
		float textHeight = paint.getFontSpacing();//文字高度（左下角）
		//画文字
		float firstPostionX = (2 * lineWidth + itemWidth)/2 - textWidth /2;
		float firstPostionY = (2 * lineWidth + itemHeight)/2 + textHeight/2;
		int size = 7;
		for (int i = 0; i < 31; i++) {
			int column = i % size;// 第几列
			int row = i /size;//第几行
			canvas.drawText(String.valueOf(i + 1), column * itemWidth
					+ firstPostionX, row * itemHeight + firstPostionY, paint);
		}
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}
	
	
}
