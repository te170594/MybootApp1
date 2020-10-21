package com.example.demo;
import org.junit.platform.surefire.provider.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.assertj.core.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.engine.*;

public class CalcTest {
	static Calc calc = null;
	@BeforeAll
	static void テスト前処理() {
	    calc = new Calc();
	}
	@Test
	void addテスト_正常() {
	    assertEquals(calc.add(1, 3), 4);
	    assertThat(calc.add(1, 3)).isEqualTo(4);
	    
	    assertEquals(calc.sub(3,1),2);
	    assertEquals(calc.div(3,1),3);
	    assertEquals(calc.mul(1,3),3);
	    
	    assertThatThrownBy(() -> {

	        calc.div(5, 0);

	    })
	    // 発生したExceptionのクラス
	    .isInstanceOf(ArithmeticException.class)
	    // エラーメッセージに特定の文字列が含まれるか）
	    .hasMessageContaining("/ by zero");
	}
	@AfterAll
	static void テスト後処理() {
	    calc = null;
	}
}
