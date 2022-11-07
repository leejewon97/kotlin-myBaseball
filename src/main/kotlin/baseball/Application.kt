package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
//	TODO("프로그램 구현")
	println("숫자 야구 게임을 시작합니다.")
	val answer = makeRandomBaseballNumber()
}

fun makeRandomBaseballNumber(): List<String> {
	val numbers = mutableListOf<String>()
	while (numbers.size < 3) {
		val number = Randoms.pickNumberInRange(1, 9).toString()
		if (number != "0")
			numbers.add(number)
	}
	return numbers
}
