package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
//	TODO("프로그램 구현")
	println("숫자 야구 게임을 시작합니다.")
	val answer = makeRandomBaseballNumber()
	var startOrExit = 1
	while (startOrExit == 1 && startOrExit != 2) {
		var userNumber = inputNumber().toMutableList()
		isValidInputNumber(userNumber)
	}
}

fun isValidInputNumber(userNumber: MutableList<Char>): Boolean {
	val userNumberSize = userNumber.size
	if (userNumberSize != 3)
		return false
	for (number in userNumber) {
		if (number !in '0'..'9')
			return false
		else if (userNumber.distinct().size != userNumberSize)
			return false
	}
	return true
}

fun inputNumber(): String {
	print("숫자를 입력해주세요 : ")
	return Console.readLine()
}

fun makeRandomBaseballNumber(): String {
	var numbers = String()
	while (numbers.length < 3) {
		val number = Randoms.pickNumberInRange(1, 9).toChar()
		if (number != '0')
			numbers += number
	}
	return numbers
}
