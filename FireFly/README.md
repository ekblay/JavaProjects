## Assignment 5

In the wild, fireflies display a natural tendency to synchronize their flashing.

They will even synchronize their flashing with a pretend firefly. For example: https://www.youtube.com/watch?v=ZGvtnE1Wy6U

Synchronization can be modeled mathematically and simulated using some reasonably simply mathematics borrowed from how coupled oscillators work. Coupled oscillators are two or more repeating things that transfer energy between themselves (often this results in them becoming synchronized).

In this assignment you will model and animate the interactions of a collection of fireflies (see for example the accompanying video file). You will do this for Fireflies that can see one another (Synchronized) and for Fireflies that cannot see one another (UnSynchronized).

To model a Firefly you should know that for our purposes, a firefly has:

1. A natural flashing frequency &omega; - this is the rate at which it wants to flash its light each second - each fire fly should have a natural frequency that never changes but is a random value between 0.24 and 0.26 flashes per second. Put another way they typically flash their light once every 4 seconds (give or take).

2. A current flashing frequency ( &delta;&phi;/&delta;t )- this is the rate at which the fly is current flashing its light each second. Without any input this is &omega;. But it can vary from &omega; if a fly is startled.

2. A current phase &phi;- this is how close they are to flashing their light next. This value should vary depending on where in the flashing cycle a fly is - this value will be between 0 and 2&Pi;. A fly starts out at a random phase value in the interval [0, 2&Pi;] and &phi; increases as time proceeds (&phi;<sub>t+1</sub> = &phi;<sub>t</sub> + &delta;&phi;/&delta;t &times; &Delta;t ; where &Delta;t is the elapsed time in seconds since the last update) wrapping around when it reaches 2&Pi; back to 0. When &phi; passes 2&Pi; the firefly flashes.

3. Ability to broadcast that it is flashing.

4. A startled factor, K. This is how much effect a firefly undergoes when it sees another firefly flashing. This is a random number between 0.06 and 0.08 for each fly. K never changes for a given fly.

A Firefly will flash at its normal frequency &omega; except for the following:

Any time it sees other flies flash it gets startled and changes its flashing frequency temporarily according to a rule of coupled oscillators, where N is the number of other flies flashing:

&delta;&phi;/&delta;t = &omega; + K * N * Sin( 2&Pi; - &phi;))

The fly will stay in this started state for 1 time step (1 second in our simulation).

Deliverables:

Using the SelectionSort Animation example. Create an animation displaying two systems at the same time. One is a system of 25 fireflies all flashing such that no fly is ever startled by another fly, i.e., they always flash at their natural frequency. The second system is also with 25 flies, except now every fly can see all of the other flies and will be startled anytime another fly flashes.

To achieve this: Run each of the 2 systems on their own thread. Such that each system is initialized as follows:

## Initialization

For each system - 25 Flies are created with random &omega; &in; [0.24, 0.26]. &omega; for a particular fly never changes once it is initialized, they are also given a random current phase: &phi; &in; [0, 2&Pi;] and a random startled factor, K &in; [0.06, 0.08].

## First System

For the `first` system your algorithm should proceed as follows:

For an infinite number of iterations the following takes place:

1. &phi; of each fly is advanced by 1 second.

2. &phi; of each fly is displayed using a line, such that the length of the line is proportional to the fly's phase, &phi; and the line is any color other than yellow, except:

3. if &phi; for a given fly surpasses 2&Pi; during that time step a line at least as long as a line representing 2&Pi; should be drawn in yellow

## Second System

For the `second` system the following takes place:

For an infinite number of iterations the following takes place:


1. &phi; of each fly is advanced by 1 second.

2. &delta;&phi;/&delta;t is updated for the next time step for each fly according to the above equation for possibly startled flies.

3. &phi; of each fly is displayed using a line, such that the length of the line is proportional to the fly's phase, &phi; and the line is any color other than yellow, except:

4. if &phi; for a given fly surpasses 2&Pi; during that time step a line at least as long as a line representing 2&Pi; should be drawn in yellow


Your finished code may look similar to the SelectionSort example from the book and should include Locks around any manipulation of the System. So that the state of the flies will only ever be drawn after every fly has been advanced to the same time step.



Gradables:

| Gradable | Points | Notes |
| --- | --- | --- |
| Readability | 2 Points | Proper names, method lengths, indentation, etc|
| Design | 3 Points | Use of classes, methods and variables |
| Functionality | 5 Points | Does the simulation run correctly |
