package space.test.gmechanics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    //Объекты дизайна для первого нижнего блока
    ImageButton shop_1;
    ImageButton shop_1_close;
    ScrollView shop_1_block;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Объявление переменных для их объектов на экране
        init_display();


        //Обработка клика
        View.OnClickListener bottomMenuClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Вызываем класс анимации и передаем блок, для которого будет применена анимация
                animationBottomMenu.animationBottomMenu(shop_1_block);
            }
        };

        //Устанавливаем кнопкам обработчик кликов
        shop_1.setOnClickListener(bottomMenuClickListener);
        shop_1_close.setOnClickListener(bottomMenuClickListener);
    }

    //Метод для объявления переменных относящихся к дизайну
    private void init_display() {

        //Присваивание переменным объектов дизайна для первого нижнего блока
        shop_1 = (ImageButton) findViewById(R.id.shop_1);
        shop_1_close = (ImageButton) findViewById(R.id.shop_1_close);
        shop_1_block = (ScrollView) findViewById(R.id.shop_1_block);
    }

    //Класс отвечающий за анимацию нижнего меню
    private static class animationBottomMenu {
        //Основной метод, в который передается ScrollView
        //Настройка анимации
        //Выборка в какое состояние должен перейти контейнер
        public static void animationBottomMenu(ScrollView scrollView) {
            TransitionManager.beginDelayedTransition(scrollView, makeSlideTransition());
            switch (scrollView.getVisibility()){
                case View.VISIBLE:
                    itemBottomMenuHidde(scrollView);
                    break;
                case View.GONE:
                case View.INVISIBLE:
                    itemBottomMenuVisible(scrollView);
                    break;
            }
        }

        private static void itemBottomMenuHidde(ScrollView scrollView) {
            scrollView.setVisibility(View.GONE);
        }

        private static void itemBottomMenuVisible(ScrollView scrollView) {
            scrollView.setVisibility(View.VISIBLE);
        }

        //Присет slide анимации
        private static Slide makeSlideTransition() {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.BOTTOM);
            slide.setInterpolator(new LinearInterpolator());
            slide.setDuration(500);
            return slide;
        }
    }
}