package com.chriswk.bowling

class BowlingScorer {
	var rolls:Array[Int] = Array()
	var index:Int = 0
	var firstBallInFrameThrown: Boolean = false;
	
	def roll(roll: Int) = {
		validate(roll)
		record(roll)
	}
	
	def validate(roll:Int) {
		if((0).to(10).contains(roll) == false) {
			throw new IllegalArgumentException("Individual rolls must be from 0 to 10")
		}
		if(openScoreAt(indexToValidate) + roll > 10) {
			throw new IllegalArgumentException("Total of rolls for frame must not exceed 10")
		}
	}
	
	def record(roll: Int) {
		rolls = rolls ++ Array(roll)
		firstBallInFrameThrown = firstBallInFrameThrown == false && roll != 10
	}
	
	def indexToValidate = {
		if(firstBallInFrameThrown) {
			rolls.length - 1
		} else {
			rolls.length
		}
	}
	
	def scoreAt(frame:Int) = {
		1.to(frame).foldLeft(0) { (total, frame) => total + nextFrameScore }
	}
	
	def score = {
		scoreAt(10)
	}
	
	def nextFrameScore = {
		var result = 0
		if(isStrike(index)) {
			result += markScoreAt(index)
			index += 1
		} else if(isSpare(index)) {
			result += markScoreAt(index)
			index += 2
		} else {
			result += openScoreAt(index)
			index += 2
		}
		result
	}
	
	def isStrike(index:Int) = {
		valueAt(index) == 10
	}
	
	def markScoreAt(index:Int) = {
		sumNext(index, 3)
	}
	
	def isSpare(index:Int) = {
		openScoreAt(index) == 10
	}
	
	def openScoreAt(index: Int) = {
		sumNext(index, 2)
	}
	
	def sumNext(index:Int, count:Int) = {
		index.until(index+count).foldLeft(0)(_ + valueAt(_))
	}
	
	def valueAt(index:Int) = {
		if(rolls.length > index) {
			rolls.apply(index)
		} else {
			0
		}
	}
}