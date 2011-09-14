package com.chriswk.bowling

import org.specs._

object BowlingScorerExampleGroup extends Specification {
	var scorer = new BowlingScorer()
	
	def roll(value:Int) {
		scorer.roll(value)
	}
	
	def rollMany(rolls:Int, value: Int) {
		0.until(rolls).foreach { arg => scorer.roll(value) }
	}
	
	def haveAScoreOf(expected:Int) {
		scorer.score must_== expected
	}
	
	def strike {
		roll(10)
	}
	
	def spare {
		rollMany(2, 5)
	}
	
	abstract class IDo {
		def Do(block: => Unit)
	}
	
	def Times(count: Int): IDo = {
		return new IDo {
			def Do(block: => Unit) {
				1.to(count).foreach( arg => block )
			}
		}
	}
	
	"A Newly Created Bowling scorer" should {
		haveAScoreOf(0)
	}
	
	"A game with all 0´s" should {
		Times(20).Do( roll(0) )
		haveAScoreOf(0)
	}
}