package afinal.itc298.com.finalgamev01;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;

/**
 * Created by jayke on 7/12/2017.
 */

public class BasicEnemy extends GameObject {

    private Paint paint = new Paint();
    private Rect rect = new Rect(0,0,75,75);
    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 16;
        velY = 32;

        GamePanel.clamp(velX, 0, 16);
        GamePanel.clamp(velY, 0, 32);

    }

    public Rect getBounds() {
        return new Rect(rect);
    }

    @Override
    public void tick(){
        x+=velX;
        y+=velY;

        if(y <= 39 || y >= Constants.SCREEN_HEIGHT - 39) velY *= -1;
        if(x <= 39 || x >= Constants.SCREEN_WIDTH -39) velX *= -1;

    }

    @Override
    public void render(Canvas canvas) {


        //fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);


        //sets position of rect, middle point is the center of rectangle
        rect.set((int)(x - rect.width()/2), (int)(y - rect.height()/2),(int)(x + rect.width()/2),(int)(y + rect.height()/2));
    }
}
