package skill.spells

	object SpellType extends Enumeration{
		type SpellType = value

		val Black = Value("Black")
		val White = Value("White")
		val Red = Value("Red")
	}

	object SpellEffect extends Enumeration{
		type SpellEffect = value

		val Heal = Value("Heal")
		val Drain = Value("Drain")
		val Damage = Value("Damage")
	}

	abstract class Spell{
		val spellType: SpellType //Black mages can't cast white magic, white mages can't cast black magic, red mages can do both but only up to a point, other classes get minimal use of a few
		val spellLevel: Int  //Could be spell level 0-9	- non mage classes can cast up to level 2 spells
		val spellEffects: SpellEffect //Spells can cause different effects 
		val name: String
	}

	class Fireball extends Spell{
		spellType = SpellType.Black
		spellLevel = 0
		spellEffects = SpellEffect.Damage
		name = "fireball"
	}

