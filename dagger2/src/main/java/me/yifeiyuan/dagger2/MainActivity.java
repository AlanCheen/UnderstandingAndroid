package me.yifeiyuan.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

/**
 * 练习 dagger2
 * 资源: https://github.com/AlanCheen/Android-Resources/blob/master/Dagger2.md
 */
public class MainActivity extends AppCompatActivity {


    @Inject
    SimpleInject mSimpleInject;

    @Inject
    SimpleProvider mSimpleProvider;

    @Inject
    Man man;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        man = DaggerManComponent.builder().build().newMan();

        mSimpleInject = DaggerSimpleInjectComponent.create().inject();
//        DaggerSimpleInjectComponent.create().inject();
        mSimpleInject.log();

        mSimpleProvider = DaggerSimpleProviderComponent.create().simple();
        mSimpleProvider.log();

        man = DaggerManComponent.create().newMan();
        man.sayHi();

    }
}
