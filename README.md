# Star Wars Universe Java Project

## Project Description

This is a Java console application for managing a Star Wars universe.

The application works with planets and Jedi.  
Each Jedi has:

- name
- rank
- age
- lightsaber color
- strength

The project supports file operations, adding planets, creating Jedi, promoting and demoting Jedi, searching for information and printing results.

The program is completely console-based and uses object-oriented programming principles.

---

# Main Features

- Open file
- Close file
- Save file
- Save file as another file
- Add planets
- Create Jedi
- Remove Jedi
- Promote Jedi
- Demote Jedi
- Print strongest Jedi
- Print youngest Jedi by rank
- Print most used saber color
- Print planet information
- Print Jedi information
- Combine information from two planets

---

# Supported Commands

## File Commands

```text
open <file>
close
save
save as <file>
help
exit
```

## Star Wars Commands

```text
add_planet <planet_name>

create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength>

removeJedi <jedi_name> <planet_name>

promote_jedi <jedi_name> <multiplier>

demote_jedi <jedi_name> <multiplier>

get_strongest_jedi <planet_name>

get_youngest_jedi <planet_name> <jedi_rank>

get_most_used_saber_color <planet_name> <jedi_rank>

get_most_used_saber_color <planet_name>

print <planet_name>

print <jedi_name>

<planet_name> + <planet_name>
```

## Example Usage

```text
open data.txt

help

print Tatooine

print Luke

get_strongest_jedi Coruscant

get_youngest_jedi Naboo PADAWAN

get_most_used_saber_color Tatooine

promote_jedi Luke 0.5

demote_jedi Luke 0.2

save

close

exit
```

## Example Data

```text
PLANET|Tatooine
JEDI|Luke|KNIGHT|23|blue|1.5
JEDI|Anakin|MASTER|35|blue|4.2

PLANET|Coruscant
JEDI|Yoda|GRAND_MASTER|900|green|10.0
JEDI|MaceWindu|MASTER|45|purple|6.5

PLANET|Naboo
JEDI|ObiWan|BATTLE_MASTER|38|blue|5.7
```
---

## Author

Teodor Todorov
Technical University of Varna
Cybersecurity