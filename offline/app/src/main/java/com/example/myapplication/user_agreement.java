package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class user_agreement extends AppCompatActivity {
    private String user_agreement = "欢迎使用虚拟教研室系统（以下简称“本系统”）。本用户协议（以下简称“协议”）是您与本系统之间关于使用本系统的协议。在使用本系统之前，请您仔细阅读并理解本协议的全部内容，如您不同意本协议的任何内容，请您停止使用本系统。\n\n1.接受条款\n1.1 您使用本系统即表示您同意遵守本协议的全部条款和条件。如果您不同意本协议的任何条款或条件，请不要使用本系统。\n1.2 本系统有权随时更改本协议的内容，修改后的协议内容将在本系统上公布。您应定期查阅本协议，以了解最新的协议内容。您继续使用本系统将被视为您接受修改后的协议内容。\n2.用户资格\n2.1 您必须年满18周岁并具有完全民事行为能力，才能使用本系统。\n3.用户账号\n3.1 您在使用本系统时可能需要创建账号，并确保您提供的信息真实、准确、完整和最新。您应妥善保管您的账号及密码，不得将其提供给他人使用。您应对您的账号和密码安全负责，因您的过失导致的损失由您自行承担。\n4.使用规则\n4.1 您同意遵守以下使用规则：\n(a) 不得利用本系统进行违法活动；\n(b) 不得干扰、破坏或篡改本系统的正常运行；\n(c) 不得利用本系统从事任何侵犯他人合法权益的行为；\n(d) 不得利用本系统进行任何可能损害本系统及其用户利益的行为。\n5.知识产权\n5.1 本系统所有的知识产权（包括但不限于软件、文本、图片、图形、音频和视频）均归本系统所有。未经本系统书面许可，任何人不得以任何形式复制、传播、展示、出售、转让或以其他方式利用本系统的内容。\n6.免责声明\n6.1 本系统不对您因使用本系统而可能遭受的任何直接、间接、偶然、特殊或间接损失负责，包括但不限于因您的行为造成的任何损失。\n7.服务变更与中断\n7.1 本系统有权随时变更、中断或终止部分或全部服务，且无需对您承担任何责任。\n8.法律适用与管辖\n8.1 本协议适用中华人民共和国法律。因本协议产生的任何争议应通过友好协商解决，协商不成的，任何一方均有权将争议提交至本协议签订地有管辖权的人民法院诉讼解决。\n9.其他\n9.1 本协议的标题仅为方便阅读而设，不影响对于条款本身的解释。\n9.2 如本协议的任何条款被裁定为无效或不可执行，不影响本协议其他条款的效力。\n9.3 本协议自生效之日起开始生效，直至您停止使用本系统或被本系统终止账户。\n您使用本系统即表示您已经阅读、理解并同意接受本协议的全部内容。如果您对本协议有任何疑问，欢迎随时与我们联系。";
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_user_agreement);
        ((TextView) findViewById(R.id.user_agreement)).setText(this.user_agreement);
        Intent intent = getIntent();
        if (intent != null) {
            this.user_name = intent.getStringExtra("user_name");
        } else {
            this.user_name = "";
        }
    }

    public void back_to_setting(View view) {
        Intent intent = new Intent(this, setting.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }
}
