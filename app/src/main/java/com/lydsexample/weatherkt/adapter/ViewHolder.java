package com.lydsexample.weatherkt.adapter;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 通用viewholder类，欢迎使用
 * 
 * @author luoyin
 *
 */
public class ViewHolder {

	private SparseArray<View> mViews;
//	Typeface wryh;
	private Context mContext;
	private View mConvertView;
	private int mposition;

	/**
	 * 构造方法，不允许在外使用
	 * 
	 * @param context
	 * @param parent
	 * @param layoutid
	 * @param position
	 */
	private ViewHolder(Context context, ViewGroup parent, int layoutid, int position) {
		mposition = position;
		mContext = context;
		mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutid, parent, false);
		mConvertView.setTag(this);
//		wryh = Typeface.createFromAsset(mContext.getAssets(), "SOURCEHANSANSCN-NORMAL.OTF");//有毒呀，打开亡3秒
	}

	/**
	 * 获取viewholder的入口方法，需要在这判断
	 * 
	 * @param context
	 * @param parent
	 * @param layoutid
	 * @param position
	 * @param convertView
	 * @return
	 */
	public static ViewHolder getHolder(Context context, ViewGroup parent, int layoutid, int position,
                                       View convertView) {
//		Log.e("当前的View是什么",""+convertView);
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutid, position);
		} else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mposition = position;
			return holder;
		}
	}

	public static ViewHolder getHolder(View convertView, int position){
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.mposition = position;
		return holder;
	}

	/**
	 * 返回最后布局
	 * 
	 * @return
	 */
	public View getconvertView() {
		return mConvertView;
	}

	/**
	 * 获取布局中的view
	 * 
	 * @param viewid
	 * @return
	 */
	public <T extends View> T getView(int viewid) {
		View view = mViews.get(viewid);
		if (view == null) {
			view = mConvertView.findViewById(viewid);
			mViews.put(viewid, view);
		}
		return (T) view;
	}

	/**
	 * 设置TextView的文本~
	 * 
	 * @param id
	 * @param text
	 */
	public ViewHolder setText(int id, String text) {
		TextView textView = getView(id);
		textView.setVisibility(View.VISIBLE);
		textView.setText(text);
		return this;
	}

	public ViewHolder setImage(int id, Drawable image){
		ImageView imageView = getView(id);
		imageView.setImageDrawable(image);
		return this;
	}

	public ViewHolder setText(int id, String text, int flag) {
		TextView textView = getView(id);
		textView.setVisibility(View.VISIBLE);
		textView.setText(text);
        if(flag == 0){
            textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else{
            textView.setBackgroundColor(Color.parseColor("#ff8c0d"));
        }
		return this;
	}

	public ViewHolder setTextVisible(int id,boolean visible){
		TextView textView = getView(id);
		if(visible){
			textView.setVisibility(View.VISIBLE);
		}else{
			textView.setVisibility(View.GONE);
		}
		return this;
	}

	//普通使用
	public ViewHolder setText(int id, String text, int flag, String color) {
		TextView textView = getView(id);
		textView.setVisibility(View.VISIBLE);
		textView.setText(text);
		if(flag == 0){
			textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
		}else{
			textView.setBackgroundColor(Color.parseColor("#ff8c0d"));
		}
		textView.setTextColor(Color.parseColor(color));
		return this;
	}

    public ViewHolder setText(int id, String text, String color) {
        TextView textView = getView(id);
        textView.setVisibility(View.VISIBLE);
        textView.setTextColor(Color.parseColor(color));
        textView.setText(text);
        return this;
    }

	public ViewHolder setBackgroundColor(int id, String color){
		View view = getView(id);
		view.setBackgroundColor(Color.parseColor(color));
		return this;
	}

	public int getTextColor(int id){
		TextView textView = getView(id);
        ColorDrawable colorDrawable= (ColorDrawable) textView.getBackground();//获取背景颜色
		return colorDrawable.getColor();
	}

	/**
	 * 网络加载图片在imageview上
	 * 
	 * @param id
	 * @param url
	 */
//	public ViewHolder setImageUrl(int id, String url) {
//		ImageView imageView = getView(id);
//		return this;
//	}

	/**
	 * 加载本地图片
	 * 
	 * @param id
	 * @param resId
	 */
//	public ViewHolder setImageUrl(int id, int resId) {
//		ImageView imageView = getView(id);
//		imageView.setImageResource(resId);
//		return this;
//	}

	/**
	 * 获取当前的位置
	 * 
	 * @return
	 */
	public int getPosition() {
		return mposition;
	}

}
