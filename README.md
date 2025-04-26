Агай I had to force the repository because my old repository stopped working, that is, how it happened when I was already doing the 10th commit I got errors in the code and in the process of correcting these errors I did something that is irreversible (I myself did not know how to fix it), that is, I got this error because when I was pushing to GitHub I initially pushed through file: / C: / Users / ansar / IdeaProjects / homework-7.2 / srk but then at the end of that day I forgot to write srk and just pushed through file: / C: / Users / ansar / IdeaProjects / homework-7.2 / and in the guide I got a lot of errors and I wrote this code in the terminal git push -u origin master --force
and everything was deleted although there were more than 10 commits I'm stuck, teacher(

Ағай уаллахи у меня было больше 10 комитов я этот код делал 2-3 дня но из за одной ошибки все испортил 😭😭😭😭




















Airport Tower Simulator (Mediator Pattern)

## About the project

This project is a simulation of an airport control tower.

It shows how several aircraft (passenger, cargo and helicopters) use a **single runway**, and how all control is centralized through the **Mediator Pattern**.

The idea is simple: aircraft do not communicate with each other directly. Their requests and messages go through the **ControlTower** — the central control node.

## What is implemented

ControlTower is a mediator that processes landing and takeoff requests, manages queues, handles emergency situations (for example, the "MAYDAY" signal).
PassengerPlane, CargoPlane, Helicopter are three types of aircraft, each reacting differently to messages from the tower.
Emergency protocol if a plane sends "MAYDAY" or is very low on fuel, it gets priority landing.
- Landing and takeoff queues work on a FIFO basis, but emergencies are handled out of turn.
SimulationDriver is the main class that runs the simulation. It creates 10 random planes and sends requests to the tower every second.




# Part 1

## Description
This project implements the **Iterator** pattern to simulate working with episodes in a Netflix-like video streaming service. We create several iterators to access episodes of a series in different modes:

- **Normal order** (SeasonIterator)
- **Reverse order** (ReverseSeasonIterator)
- **Shuffle order** with a fixed seed (ShuffleSeasonIterator)
- **Skip intro** for each episode (SkipIntroIterator)
- **Watched episode filter** (WatchHistoryFilte)

The project is intended to demonstrate working with different iterators, as well as how you can conveniently work with collections in Java, hiding their implementation details.

## Project structure
- **Episode**: represents a single episode in a series, including the title and duration.
- **Season**: represents a season of a TV series, which contains a list of episodes.
- **Iterator**:
- **SeasonIterator**: iterates through the episodes of a season in normal order.
- **ReverseSeasonIterator**: iterates through the episodes of a season in reverse order.
- **ShuffleSeasonIterator**: randomizes the order of episodes with a fixed seed.
- **SkipIntroIterator**: skips a specified number of seconds at the beginning of an episode.
- **WatchHistoryFilte**: filters watched episodes, returning only those that have not yet been watched.
- **BingeIterator**: allows you to watch all episodes from different seasons in a row.












