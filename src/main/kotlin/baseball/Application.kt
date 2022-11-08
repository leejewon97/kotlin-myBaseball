package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
//	TODO("프로그램 구현")
	println("숫자 야구 게임을 시작합니다.")
	val answer = makeRandomBaseballNumber()
	var startOrExit = 1
	while (startOrExit == 1 && startOrExit != 2) {
		var userNumber = inputNumber()
		callException(isValidInputNumber(userNumber))
		calculateBaseballScore(userNumber, answer)
	}
}

fun calculateBaseballScore(userNumber: String, answer: String): Int {
	val ball = countBall(userNumber, answer)
	val strike = countStrike(userNumber, answer)
	if (ball == 0 && strike == 0)
		println("낫싱")
	else if (ball != 0 && strike != 0)
		println("${ball}볼 ${strike}스트라이크")
	else if (ball != 0)
		println("${ball}볼")
	else
		println("${strike}스트라이크")
	return strike
}

fun callException(isValid: Boolean) {
	if (!isValid)
		throw IllegalArgumentException("program exit")
}

fun isValidInputNumber(userNumber: String): Boolean {
	val userNum = userNumber.toMutableList()
	val userNumSize = userNum.size
	if (userNumSize != 3)
		return false
	for (num in userNum) {
		if (num !in '0'..'9')
			return false
		else if (userNum.distinct().size != userNumSize)
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
