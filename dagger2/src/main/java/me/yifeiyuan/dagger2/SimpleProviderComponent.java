package me.yifeiyuan.dagger2;

import dagger.Component;

/**
 * Created by 程序亦非猿 on 16/9/27.
 */
@Component(modules = SimpleProviderModule.class)
public interface SimpleProviderComponent {
    SimpleProvider simple();
}
