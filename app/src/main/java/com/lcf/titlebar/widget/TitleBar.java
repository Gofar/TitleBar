package com.lcf.titlebar.widget;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcf.titlebar.R;

/**
 * Author: lcf
 * Description:自定义ToolBar，可以标题居中，可以往左边、中间、右边添加自定义View
 * Since: 1.0
 * Date: 2017/5/10 17:23
 */
public class TitleBar extends Toolbar {
    /**
     * 居中标题
     */
    private TextView mCenterTextView;
    /**
     * 居中标题的TitleTextAppearance
     */
    private int mCenterTitleTextAppearance;
    /**
     * 居中标题的颜色
     */
    private int mCenterTitleTextColor;
    /**
     * 居中标题的文本
     */
    private CharSequence mCenterTitle;


    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resolveAttrs(attrs, defStyleAttr);
    }

    /**
     * 读取ToolBar的默认标题属性
     *
     * @param attrs        AttributeSet
     * @param defStyleAttr defStyleAttr
     */
    private void resolveAttrs(AttributeSet attrs, int defStyleAttr) {
        // Need to use getContext() here so that we use the themed context
        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                R.styleable.Toolbar, defStyleAttr, 0);
        mCenterTitleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        mCenterTitleTextColor = a.getColor(R.styleable.Toolbar_titleTextColor, 0xffffffff);
        a.recycle();
    }

    /**
     * 设置居中标题
     *
     * @param resId Resource ID of a string to set as the title
     */
    public void setCenterTitle(@StringRes int resId) {
        setCenterTitle(getContext().getString(resId));
    }

    /**
     * 设置居中标题
     * 模仿ToolBar中的写法,样式与ToolBar中标题一致
     *
     * @param title 标题文本
     */
    public void setCenterTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (mCenterTextView == null) {
                Context context = getContext();
                mCenterTextView = new AppCompatTextView(context);
                mCenterTextView.setSingleLine();
                mCenterTextView.setEllipsize(TextUtils.TruncateAt.END);
                if (mCenterTitleTextAppearance != 0) {
                    mCenterTextView.setTextAppearance(context, mCenterTitleTextAppearance);
                }
                if (mCenterTitleTextColor != 0) {
                    mCenterTextView.setTextColor(mCenterTitleTextColor);
                }
            }
            if (mCenterTextView.getParent() != this) {
                addCenterView(mCenterTextView);
            }
        } else if (mCenterTextView != null && mCenterTextView.getParent() == this) {
            // mCenterTextView已添加时，若设置title为空,就移除mCenterTextView
            removeView(mCenterTextView);
        }
        if (mCenterTextView != null) {
            mCenterTextView.setText(title);
        }
        mCenterTitle = title;
    }

    /**
     * 获取居中标题的文本
     *
     * @return 居中标题的文本
     */
    public CharSequence getCenterTitle() {
        return mCenterTitle;
    }

    /**
     * 设置居中标题的文本颜色
     *
     * @param color 颜色值
     */
    public void setCenterTitleColor(@ColorInt int color) {
        mCenterTitleTextColor = color;
        if (mCenterTextView != null) {
            mCenterTextView.setTextColor(color);
        }
    }

    /**
     * 添加一个居中的View
     * 有时候ToolBar中间不是文本，是一个其他View,或想显示自定义居中标题的View,可以在这里传入一个View
     * 不与 {@link #setCenterTitle(CharSequence)} 同时使用
     *
     * @param view 放在中间的View
     */
    public void addCenterView(View view) {
        addCustomView(view, Gravity.CENTER);
    }

    /**
     * 添加一个左边的View
     * 左边是一个图片按钮时可以直接使用{@link #setNavigationIcon(int)}
     * 若想放一个自定义View，可以使用此方法
     *
     * @param views 想要依次排列的View
     */
    public void addLeftView(View... views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            if (view != null) {
                addCustomView(view, Gravity.LEFT);
            }
        }
    }

    /**
     * 添加一个右边的View
     * ToolBar右边菜单可以使用Menu，若想展示自己的样式，
     * 可以使用{@link android.view.MenuItem#setActionView(int)}
     * 或{@link android.view.MenuItem#setActionView(View)}这两个方法将自定义View展示在Menu上
     * 也可以使用本方法往右边添加自定义View
     *
     * @param views 想要依次排列的View
     */
    public void addRightView(View... views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            if (view != null) {
                addCustomView(view, Gravity.RIGHT);
            }
        }
    }

    /**
     * 添加自定义View
     *
     * @param v       view
     * @param gravity gravity
     */
    private void addCustomView(View v, int gravity) {
        ViewGroup.LayoutParams vlp = v.getLayoutParams();
        LayoutParams lp;
        if (vlp == null) {
            lp = generateDefaultLayoutParams(gravity);
        } else if (!checkLayoutParams(vlp)) {
            lp = generateLayoutParams(vlp, gravity);
        } else {
            lp = (LayoutParams) vlp;
        }
        addView(v, lp);
    }

    /**
     * 创建{@link LayoutParams}
     * 用于指定添加到ToolBar的View的位置
     *
     * @param gravity CENTER,LEFT,RIGHT
     * @return LayoutParams
     */
    private LayoutParams generateDefaultLayoutParams(int gravity) {
        return new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, gravity);
    }

    /**
     * 创建{@link LayoutParams}
     * 用于指定添加到ToolBar的View的位置
     *
     * @param lp      view的LayoutParams
     * @param gravity CENTER,LEFT,RIGHT
     * @return LayoutParams
     */
    private LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp, int gravity) {
        LayoutParams layoutParams;
        if (lp instanceof LayoutParams) {
            layoutParams = new LayoutParams((LayoutParams) lp);
        } else if (lp instanceof ActionBar.LayoutParams) {
            layoutParams = new LayoutParams((ActionBar.LayoutParams) lp);
        } else if (lp instanceof MarginLayoutParams) {
            layoutParams = new LayoutParams((MarginLayoutParams) lp);
        } else {
            layoutParams = new LayoutParams(lp);
        }
        layoutParams.gravity = gravity;
        return layoutParams;
    }
}
