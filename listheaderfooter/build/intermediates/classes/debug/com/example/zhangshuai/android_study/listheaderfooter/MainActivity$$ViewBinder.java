// Generated code from Butter Knife. Do not modify!
package com.example.zhangshuai.android_study.listheaderfooter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.example.zhangshuai.android_study.listheaderfooter.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492946, "field 'lv_test'");
    target.lv_test = finder.castView(view, 2131492946, "field 'lv_test'");
  }

  @Override public void unbind(T target) {
    target.lv_test = null;
  }
}
