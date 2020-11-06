package com.wangxingxing.wxxeventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.wangxingxing.myeventbus.EventBus;

/***
 *            .,,       .,:;;iiiiiiiii;;:,,.     .,,
 *          rGB##HS,.;iirrrrriiiiiiiiiirrrrri;,s&##MAS,
 *         r5s;:r3AH5iiiii;;;;;;;;;;;;;;;;iiirXHGSsiih1,
 *            .;i;;s91;;;;;;::::::::::::;;;;iS5;;;ii:
 *          :rsriii;;r::::::::::::::::::::::;;,;;iiirsi,
 *       .,iri;;::::;;;;;;::,,,,,,,,,,,,,..,,;;;;;;;;iiri,,.
 *    ,9BM&,            .,:;;:,,,,,,,,,,,hXA8:            ..,,,.
 *   ,;&@@#r:;;;;;::::,,.   ,r,,,,,,,,,,iA@@@s,,:::;;;::,,.   .;.
 *    :ih1iii;;;;;::::;;;;;;;:,,,,,,,,,,;i55r;;;;;;;;;iiirrrr,..
 *   .ir;;iiiiiiiiii;;;;::::::,,,,,,,:::::,,:;;;iiiiiiiiiiiiri
 *   iriiiiiiiiiiiiiiii;;;::::::::::::::::;;;iiiiiiiiiiiiiiiir;
 *  ,riii;;;;;;;;;;;;;:::::::::::::::::::::::;;;;;;;;;;;;;;iiir.
 *  iri;;;::::,,,,,,,,,,:::::::::::::::::::::::::,::,,::::;;iir:
 * .rii;;::::,,,,,,,,,,,,:::::::::::::::::,,,,,,,,,,,,,::::;;iri
 * ,rii;;;::,,,,,,,,,,,,,:::::::::::,:::::,,,,,,,,,,,,,:::;;;iir.
 * ,rii;;i::,,,,,,,,,,,,,:::::::::::::::::,,,,,,,,,,,,,,::i;;iir.
 * ,rii;;r::,,,,,,,,,,,,,:,:::::,:,:::::::,,,,,,,,,,,,,::;r;;iir.
 * .rii;;rr,:,,,,,,,,,,,,,,:::::::::::::::,,,,,,,,,,,,,:,si;;iri
 *  ;rii;:1i,,,,,,,,,,,,,,,,,,:::::::::,,,,,,,,,,,,,,,:,ss:;iir:
 *  .rii;;;5r,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,sh:;;iri
 *   ;rii;:;51,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.:hh:;;iir,
 *    irii;::hSr,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.,sSs:;;iir:
 *     irii;;:iSSs:.,,,,,,,,,,,,,,,,,,,,,,,,,,,..:135;:;;iir:
 *      ;rii;;:,r535r:...,,,,,,,,,,,,,,,,,,..,;sS35i,;;iirr:
 *       :rrii;;:,;1S3Shs;:,............,:is533Ss:,;;;iiri,
 *        .;rrii;;;:,;rhS393S55hh11hh5S3393Shr:,:;;;iirr:
 *          .;rriii;;;::,:;is1h555555h1si;:,::;;;iirri:.
 *            .:irrrii;;;;;:::,,,,,,,,:::;;;;iiirrr;,
 *               .:irrrriiiiii;;;;;;;;iiiiiirrrr;,.
 *                  .,:;iirrrrrrrrrrrrrrrrri;:.
 *                        ..,:::;;;;:::,,.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SecondActivity";

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