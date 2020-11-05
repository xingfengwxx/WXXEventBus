package com.wangxingxing.wxxeventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wangxingxing.myeventbus.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SecondActivity";

    public static final String FUN_STR = "/***                                                                    \n" +
            " *            .,,       .,:;;iiiiiiiii;;:,,.     .,,                   \n" +
            " *          rGB##HS,.;iirrrrriiiiiiiiiirrrrri;,s&##MAS,                \n" +
            " *         r5s;:r3AH5iiiii;;;;;;;;;;;;;;;;iiirXHGSsiih1,               \n" +
            " *            .;i;;s91;;;;;;::::::::::::;;;;iS5;;;ii:                  \n" +
            " *          :rsriii;;r::::::::::::::::::::::;;,;;iiirsi,               \n" +
            " *       .,iri;;::::;;;;;;::,,,,,,,,,,,,,..,,;;;;;;;;iiri,,.           \n" +
            " *    ,9BM&,            .,:;;:,,,,,,,,,,,hXA8:            ..,,,.       \n" +
            " *   ,;&@@#r:;;;;;::::,,.   ,r,,,,,,,,,,iA@@@s,,:::;;;::,,.   .;.      \n" +
            " *    :ih1iii;;;;;::::;;;;;;;:,,,,,,,,,,;i55r;;;;;;;;;iiirrrr,..       \n" +
            " *   .ir;;iiiiiiiiii;;;;::::::,,,,,,,:::::,,:;;;iiiiiiiiiiiiri         \n" +
            " *   iriiiiiiiiiiiiiiii;;;::::::::::::::::;;;iiiiiiiiiiiiiiiir;        \n" +
            " *  ,riii;;;;;;;;;;;;;:::::::::::::::::::::::;;;;;;;;;;;;;;iiir.       \n" +
            " *  iri;;;::::,,,,,,,,,,:::::::::::::::::::::::::,::,,::::;;iir:       \n" +
            " * .rii;;::::,,,,,,,,,,,,:::::::::::::::::,,,,,,,,,,,,,::::;;iri       \n" +
            " * ,rii;;;::,,,,,,,,,,,,,:::::::::::,:::::,,,,,,,,,,,,,:::;;;iir.      \n" +
            " * ,rii;;i::,,,,,,,,,,,,,:::::::::::::::::,,,,,,,,,,,,,,::i;;iir.      \n" +
            " * ,rii;;r::,,,,,,,,,,,,,:,:::::,:,:::::::,,,,,,,,,,,,,::;r;;iir.      \n" +
            " * .rii;;rr,:,,,,,,,,,,,,,,:::::::::::::::,,,,,,,,,,,,,:,si;;iri       \n" +
            " *  ;rii;:1i,,,,,,,,,,,,,,,,,,:::::::::,,,,,,,,,,,,,,,:,ss:;iir:       \n" +
            " *  .rii;;;5r,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,sh:;;iri        \n" +
            " *   ;rii;:;51,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.:hh:;;iir,        \n" +
            " *    irii;::hSr,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.,sSs:;;iir:         \n" +
            " *     irii;;:iSSs:.,,,,,,,,,,,,,,,,,,,,,,,,,,,..:135;:;;iir:          \n" +
            " *      ;rii;;:,r535r:...,,,,,,,,,,,,,,,,,,..,;sS35i,;;iirr:           \n" +
            " *       :rrii;;:,;1S3Shs;:,............,:is533Ss:,;;;iiri,            \n" +
            " *        .;rrii;;;:,;rhS393S55hh11hh5S3393Shr:,:;;;iirr:              \n" +
            " *          .;rriii;;;::,:;is1h555555h1si;:,::;;;iirri:.               \n" +
            " *            .:irrrii;;;;;:::,,,,,,,,:::;;;;iiirrr;,                  \n" +
            " *               .:irrrriiiiii;;;;;;;;iiiiiirrrr;,.                    \n" +
            " *                  .,:;iirrrrrrrrrrrrrrrrri;:.                        \n" +
            " *                        ..,:::;;;;:::,,.                             \n" +
            " */  ";

    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnPost = findViewById(R.id.btn_post);
        btnPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (R.id.btn_post) {
            case R.id.btn_post:
                postMsg();
                break;
        }
    }

    private void postMsg() {
        Log.i(TAG, "postMsg: post thread name: " + Thread.currentThread().getName());
        EventBus.getInstance().post("Hello，大噶好，我系渣渣辉");
        finish();
    }
}