package com.cdx.example.animation.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenSelfRotateActivity extends AppCompatActivity {

    private ImageView view1,view2,view3,view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_self_rotate);

        view1 = findViewById(R.id.iv1);
        view2  =  findViewById(R.id.iv2);
        view3  =  findViewById(R.id.iv3);
        view4  =  findViewById(R.id.iv4);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.animal);

        view1.setImageBitmap(bitmap);

        /**
         * 1、由于没有对Matrix做任何的处理，所以Camera的ratateY()方法再以Y轴旋转的时候，旋转中心为（0,0）
         * 2、请看pic中的图片1.png
         * 3、因为旋转中心并不在图片的对称点上，所以得到的结果就是图片上下不对称。
         * 旋转中心为(0,0)
         */
        Matrix matrix = getMatrix();
        Bitmap bit = getBitmap(bitmap, matrix);
        view2.setImageBitmap(bit);

        /**
         * 旋转中心为(0,height/2)
         */
        matrix = getMatrix();
        //preTranslate方法作用就是在旋转之前先将图片向上移动高度一半的距离
        //这样图片就关于x轴对称了，然后再进行旋转的变化。
        matrix.preTranslate(0, -bitmap.getHeight() / 2);
        //postTranslate方法作用就是在旋转之后将图片向下移动高度一半的距离,也就是回到了原来的位置
        //这样图片显示的结果就是对称的了。
        //原理也很简单：旋转中心也是（0,0），只不过我们移动图片，这样旋转的时候就能得到对称的结果了。
        //请看pic中的2.png
        matrix.postTranslate(0, bitmap.getHeight() / 2);
        bit = getBitmap(bitmap, matrix);
        view3.setImageBitmap(bit);

        /**
         * 旋转中心为(0,height)
         */
        matrix = getMatrix();
        matrix.preTranslate(0, -bitmap.getHeight());
        matrix.postTranslate(0,bitmap.getHeight());
        bit = getBitmap(bitmap, matrix);
        view4.setImageBitmap(bit);
    }

    private Bitmap getBitmap(Bitmap bitmap, Matrix matrix) {
        //从原始位剪切图像，这是一种高级的语法，可以用Matrix实现旋转等高级方式截图。
        //第一个参数：截图的原始位图
        //第二个参数：起始x坐标
        //第三个参数：起始y坐标
        //第四个参数：要截得图的宽度
        //第五个参数：要截得图的高度
        //第六个参数：变化的矩阵
        //第7个参数：
        return Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
    }

    /*
     * 旋转的话，需要借助于Matrix和Camera两个类，
     * 并且将Camera中的参数封装到Matrix中,进行返回
     */
    @NonNull
    private Matrix getMatrix(){
        //旋转借助于Matrix和Camera
        Matrix matrix = new Matrix();
        Camera camera = new Camera();
        camera.save();
        camera.rotateY(45);//旋转45度
        camera.getMatrix(matrix);
        camera.restore();
        return matrix;
    }
}
