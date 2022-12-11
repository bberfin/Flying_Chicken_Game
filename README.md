# Flying_Chicken_Game
 This is a simple 2-D game will be played by keyboard. A chicken will fall vertically 
while trying to avoid cats randomly waiting on its path with an open mouth. During this journey, 
the chicken aims to hit targets appearing left and right sides of its path randomly by using its 
golden eggs. The eggs will be launched by its mouth. Once a target is hit, the player will get 
points according to the size of the target.

- This game is implemented by Java
#

> 1- In the game, the use of a keyboard is required to move the chicken, and a mouse is 
required for golden egg throwing.

 ◼ With the letter “ D ” or “ ” right arrow key chicken is moved to the right.

 ◼ With the letter “ A ” or “ ” left arrow key chicken is moved to the left.

 ◼  Golden eggs are thrown with by mouse. Aim the target with the mouse and shoot with the left mouse click.
 
![Ekran Görüntüsü (53)](https://user-images.githubusercontent.com/72701330/206899482-daecb9df-238e-4cb2-ae9a-5804208027bb.png)

> 2- There are two different targets in the game and the points earned vary according to the size of the targets. If the chicken hits these targets with its golden eggs, it earns points. Targets appear randomly in every new game and level.

![image](https://user-images.githubusercontent.com/72701330/206899262-ec4cb8b8-2707-4415-b7c2-691fbe598769.png) ![image](https://user-images.githubusercontent.com/72701330/206899273-b3001481-f4e7-48ee-92ee-75cee900ae1c.png)

◼ One of the targets is the small egg basket . -----> 10 points are earned

◼ The other one is the large egg basket . -----> 30 points are earned

> 3- The game consists of 3 levels. The higher the game level, the harder the game is.

◼	The speed of each level increases more than the previous level.

◼	In levels 2 and 3, the big cats is included in the game.

◼ At level 3, the walls are closer to each other and the playing area is narrower.

> 4- Cats appear randomly in every new game and level. When the chicken collides with the cats, its hearts decreases.

![image](https://user-images.githubusercontent.com/72701330/206899359-60431533-5717-4870-aefe-2c7921b7dfe7.png) ![image](https://user-images.githubusercontent.com/72701330/206899362-d213b441-328a-4481-b135-a48d56341532.png)

◼	Little black cat  (exists at all levels)  ----->   -1 heart 
◼ Big cat  (only exist at level 2 and 3)  ----->   -3 heart

> 5- Chicken has 10 hearts for each level. If the chicken has no hearts left, the player loses the game.

◼	In the upper left corner of the game is the life bar and current score text.

◼	From the moment the number of hearts falls below 5, the heart bar turns from green to red.    

![image](https://user-images.githubusercontent.com/72701330/206899400-7d5d6db6-fa36-4add-bd33-753ab1879cd3.png) ![image](https://user-images.githubusercontent.com/72701330/206899403-4784a53b-6cd1-44aa-a84b-d49d3f3032f4.png)

> 6- When the player loses the game or reaches the finish line, the total points achieved so far are shown on the screen. In addition, the player is given 2 options to restart the game or to quit the game.

> (For restart) At the beginning of each new game, data such as the total points are reset and the number of hearts becomes 10 again.

![image](https://user-images.githubusercontent.com/72701330/206899422-149d19cb-6e1c-4ce7-9bba-dd71c1274e74.png) ![image](https://user-images.githubusercontent.com/72701330/206899423-3e459a95-c7c4-4f5c-9d8a-dd0e49eb90e2.png)

# DIAGRAMS

> USE CASE DIAGRAM (BASIC)

![Ekran Görüntüsü (55)](https://user-images.githubusercontent.com/72701330/206899637-bd2135e0-c92a-48e2-aa12-477945b43458.png)

> USE CASE DIAGRAM (EXTENDED)

![Ekran Görüntüsü (56)](https://user-images.githubusercontent.com/72701330/206899659-eb436b2b-ad57-4ef9-8907-b43a780c4545.png)

> ACTIVITY DIAGRAM

![Ekran Görüntüsü (57)](https://user-images.githubusercontent.com/72701330/206899677-bcebe934-98b2-4046-bc4a-515ddea4bbce.png)
