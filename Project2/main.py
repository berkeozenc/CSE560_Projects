from os import listdir
from random import *
import math

def readData():

    inputFiles = listdir("olcay-tsp/")
    allData = {}
    for fName in inputFiles:
        cityName = fName.split(".")[0]
        allData[cityName] = list()
        f = open("olcay-tsp/" + fName, 'r', encoding="utf-8")
        lines = f.readlines()
        for l in lines:
            city = l.split(" ")
            city[2] = city[2].replace("\n","")
            allData[cityName].append(city)
    return allData


def createInitials(numOfInst):
    population = list()
    for i in range(numOfInst):
        instance = {"gene": list()}
        j = 0
        while j < len(cityList):
            randomCity = randint(1, len(cityList))
            if randomCity not in instance["gene"]:
                instance["gene"].append(randomCity)
                j = j + 1
        instance["fitness"] = calculateFitness(instance["gene"])
        #print(instance)
        population.append(instance)
    return population

def calculateFitness(gene):
    totalDist = 0
    for i in range(len(gene)):
        if i < len(gene)-1:
            start = gene[i]
            end = gene[i+1]
            x1 = float(cityList[start-1][1])
            y1 = float(cityList[start-1][2])
            x2 = float(cityList[end-1][1])
            y2 = float(cityList[end-1][2])
            totalDist += math.sqrt(math.pow((x1-x2),2)+math.pow((y1-y2),2))
            #print( str(start) + " to " + str(end) + " --> " + str(math.sqrt(math.pow((x1-x2),2)+math.pow((y1-y2),2))))
    return totalDist

def crossover(parent1, parent2):
    offspring1 = list()
    offspring2 = list()

    for i in range(len(parent1)):
        if i < len(parent1)/2:
            offspring1.append(parent1[i])
            offspring2.append(parent2[i])
        else:
            offspring1.append(parent2[i])
            offspring2.append(parent1[i])

    offspring1 = clearGene(offspring1)
    offspring2 = clearGene(offspring2)
    return offspring1, offspring2

def clearGene(gene):
    a = list()
    for i in range(len(cityList)):
        a.append(i+1)
    setA = set(a)
    setG = set(gene)
    diff = list(setA-setG)
    diffIndex = 0
    mid = int(len(gene)/2)+1
    for i in range(mid):
        for j in range(mid, len(gene)):
            if gene[i] == gene[j]:
                gene[j] = diff[diffIndex]
                diffIndex += 1
    return gene

def mate(parent1, parent2):
    o1Gene, o2Gene = crossover(parent1["gene"], parent2["gene"])
    offspring1 = {"gene": o1Gene, "fitness": calculateFitness(o1Gene)}
    offspring2 = {"gene": o2Gene, "fitness": calculateFitness(o2Gene)}
    #print(parent1["gene"])
    #print(parent2["gene"])
    #print(offspring1)
    #print(offspring2)
    return offspring1, offspring2

def mutate(gene):
    print(gene)
    i = randint(0, len(gene)-1)
    j = randint(0, len(gene)-1)

    while( i == j) :
        j = randint(0, len(gene)-1)
    try:
        temp = gene[i]
    except:
        print(i)
        exit(0)
    gene[i] = gene[j]
    gene[j] = temp
    print(gene)
    return gene

def printPop(pop):
    print("---- Currnet POP ----")
    for p in pop:
        print(p)
    print("---------------------")

global cityList
allData = readData()
cityList = allData["oty"]
pop = createInitials(100)

while True:


    if(len(pop) == 0):
        exit(0)
    printPop(pop)

    for i in range(len(pop)):
        parent1Index = randint(0, len(pop) - 1)
        parent2Index = randint(0, len(pop) - 1)
        while parent1Index == parent2Index:
            parent2Index = randint(0, len(pop) - 1)
        offspring1, offspring2 = mate(pop[parent1Index], pop[parent2Index])
        #print("BORN :: " + str(offspring1))
        #print("BORN :: " + str(offspring2))
        pop.append(offspring1)
        pop.append(offspring2)

    mutaChance = randint(1,100)
    if mutaChance == 1:
        x = randint(0,len(pop)-1)
        pop[x]["gene"] = mutate(pop[x]["us-states"])

    p = 0
    while p < len(pop):
        if pop[p]["fitness"] > 11:
            #print("DEAD :: " + str(pop[p]))
            pop.remove(pop[p])
        else:
            p += 1

#73924 western-sahara
#22126 dijibouti
#85537 qatar
#82540 uruguay
#86599 us