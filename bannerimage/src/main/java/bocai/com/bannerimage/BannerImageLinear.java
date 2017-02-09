package bocai.com.bannerimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者 yuanfei on 2017/2/7.
 * 邮箱 yuanfei221@126.com
 */

public class BannerImageLinear extends LinearLayout {
    private Context context;
    private Roll3DView roll3DView;
    Timer timer;
    int i = 0;
    TimerTask task;
    private ImageView[] indicators;
    private List<ImageView> imageViews = new ArrayList<ImageView>();
    private LinearLayout linearLayout;
    private int pageItemWidth = 15;
    private int direction = 1;
    private int partNumber = 12;
    private int unselectImage = R.drawable.icon_point;
    private int selectImage = R.drawable.icon_point_pre;
    private boolean isIndicator = true;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int index = msg.arg1%4;
                Log.e("handleMessage",msg.arg1+"");
                roll3DView.toPre();
                if (isIndicator) {
                    setIndicator(index);
                }
            }
            super.handleMessage(msg);
        }
    };

    public BannerImageLinear(Context context) {
        super(context);
        init(context);
    }

    public BannerImageLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BannerImageLinear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View.inflate(context, R.layout.banner_linear,this);
        linearLayout = (LinearLayout) findViewById(R.id.llGuideGroup);
        roll3DView = (Roll3DView) findViewById(R.id.rollView);
        roll3DView.setRollMode(Roll3DView.RollMode.RollInTurn);
        roll3DView.setPartNumber(partNumber);
        roll3DView.setRollDirection(direction);
//        roll3DView.toNext();
    }

    public void setDicators(int index){
        indicators = new ImageView[index];
        for (int i = 0; i < indicators.length; i++) {
//            View view = LayoutInflater.from(context).inflate(
//                    R.layout.view_cycle_viewpager_indicator, null);
            indicators[i] = new ImageView(context);
        }
    }

    /**
     * 设置滚动方向 1竖直方向  其他为水平方向
     * @param direction
     */
    public void setDirection(int direction){
        this.direction = direction;
        roll3DView.setRollDirection(direction);
    }

    /**
     * 设置分块的数量  建议是3的倍数
     * @param partNumber
     */
    public void setPartNumber(int partNumber){
        this.partNumber = partNumber;
        roll3DView.setPartNumber(partNumber);
    }

    public void setIndicatorImage(int unselectImage,int selectImage){
        this.unselectImage = unselectImage;
        this.selectImage = selectImage;
    }

    public void setIsIndicator(boolean isIndicator){
        this.isIndicator = isIndicator;
    }

    public Roll3DView getRoll3DView() {
        return roll3DView;
    }

    public void startAnim() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                i++;
                Message message = new Message();
                message.arg1 = i;
                message.what = 1;
                mHandler.sendMessage(message);
            }
        };
        timer.schedule(task,0,3000);
    }
    private void stopTimer(){
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    /**
     * 设置指示器
     *
     * @param selectedPosition
     *            默认指示器位置
     */
    private void setIndicator(int selectedPosition) {
        linearLayout.removeAllViews();
        for (int i = 0; i < indicators.length; i++) {
            indicators[i]
                    .setBackgroundResource(unselectImage);
            if (selectedPosition == i){
                if (indicators.length > selectedPosition)
                    indicators[selectedPosition]
                            .setBackgroundResource(selectImage);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(pageItemWidth,pageItemWidth);
            params.setMargins(pageItemWidth,0,0,0);
            indicators[i].setLayoutParams(params);
            linearLayout.addView(indicators[i]);
        }


    }
    public void addBitmap(Bitmap bitmap){
        roll3DView.addImageBitmap(bitmap);
    }
}
