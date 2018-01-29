trait Mage extends Character{
}

trait BlackMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(lvl >= (spell.spellLevel * 5)){
			if(spell.spellType == SpellType.Black) {
				if(target.dodge){
					println("Missed!")
				}
				else{
					target.hpAffected(damageCalc)				
				}
			}	
			else{
				println("Black mages can only use black magic spells...")
			}
		}
		else{
			println("Level too low!")
		}
	}
}

trait RedMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(lvl >= (spell.spellLevel * 5) && spell.spellLevel < 6){
				if(target.dodge){
					println("Missed!")
				}
				else{
					target.hpAffected(damageCalc)				
				}
		}
		else{
			println("Level too low!")
		}
	}
}

trait WhiteMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(lvl >= (spell.spellLevel * 5)){
			if(spell.spellType == SpellType.White) {
					target.hpAffected(healCalc)				
			}	
			else{
				println("White mages can only use white magic spells...")
			}
		}
		else{
			println("Level too low!")
		}
	}
}