package me.yifeiyuan.dagger2.constructor;

import dagger.Component;

/**
 * Created by 程序亦非猿 on 16/9/27.
 *
 * Error:(11, 18) 错误:
 * me.yifeiyuan.dagger2.SimpleInject cannot be provided without an @Inject constructor or from an @Provides-annotated method.
 * me.yifeiyuan.dagger2.SimpleInject is provided at
 * me.yifeiyuan.dagger2.SimpleInjectComponent.create()
 */
@Component
public interface ConstructorInjectComponent {
    // 方法名字不能定义为 create 在 Dagger 自动生成的方法中已经有了 create 方法
    // ConstructorInject create();

    // Component 要求 ConstructorInject 有 @Inject的构造方法 或为 Component提供Module (@Provides)
    ConstructorInject inject();

//    void inject(MainActivity activity);
}
