# Star Wars Universe

Java console application for managing planets and Jedi in a Star Wars universe.

## Main functionality

- Open, close, save and save as file
- Add new planets
- Create Jedi
- Remove Jedi from planet
- Promote and demote Jedi
- Print strongest Jedi
- Print youngest Jedi by rank
- Print most used saber color
- Print planet information
- Print Jedi information
- Combine information from two planets

## Commands

open <file>
close
save
save as <file>
help
exit

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

## File format

The program stores data in a text file.

Example:

PLANET|Tatooine
JEDI|Luke|KNIGHT|23|blue|1.5

## Classes

- Main - reads commands from the console
- Universe - manages planets and Jedi
- Planet - stores planet name and Jedi list
- Jedi - stores Jedi information
- Rank - enum for Jedi ranks
- FileManager - loads and saves data from file