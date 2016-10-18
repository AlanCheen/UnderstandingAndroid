package me.yifeiyuan.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import me.yifeiyuan.dagger2.constructor.ConstructorInject;
import me.yifeiyuan.dagger2.constructor.DaggerConstructorInjectComponent;
import me.yifeiyuan.dagger2.method.DaggerMethodInjectComponent;
import me.yifeiyuan.dagger2.method.MethodInject;
import me.yifeiyuan.dagger2.module.DaggerHeroComponent;
import me.yifeiyuan.dagger2.module.DaggerModuleInjectComponent;
import me.yifeiyuan.dagger2.module.Hero;
import me.yifeiyuan.dagger2.module.HeroModule;
import me.yifeiyuan.dagger2.module.ModuleInject;
import me.yifeiyuan.dagger2.module.ModuleInjectModule;
import me.yifeiyuan.dagger2.module.Weapon;

/**
 * 练习 dagger2
 * 资源: https://github.com/AlanCheen/Android-Resources/blob/master/Dagger2.md
 */
public class MainActivity extends AppCompatActivity {


    @Inject
    ConstructorInject mConstructorInject;

    @Inject
    MethodInject mMethodInject;

//    error
//    @Inject
//    MultiConsInject mMultiConsInject;

    @Inject
    SimpleProvider mSimpleProvider;


    @Inject
    ModuleInject mModuleInject;

    @Inject
    Man man;

    @Inject
    Hero mHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstructorInject = DaggerConstructorInjectComponent.create().inject();
        mConstructorInject.log();

        mMethodInject = DaggerMethodInjectComponent.create().inject();
        mMethodInject.hi();

        mSimpleProvider = DaggerSimpleProviderComponent.create().simple();
        mSimpleProvider.log();

        man = DaggerManComponent.builder().build().newMan();
        man = DaggerManComponent.create().newMan();
        man.sayHi();


        mModuleInject = DaggerModuleInjectComponent
                .builder()
                .moduleInjectModule(new ModuleInjectModule())
                .build()
                .inject();

        mModuleInject.sayHi();

        mHero = DaggerHeroComponent
                .builder()
                .heroModule(new HeroModule(new Weapon().setName("三板斧")))
                .build()
                .inject();
    }
}
