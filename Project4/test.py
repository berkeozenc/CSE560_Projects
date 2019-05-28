import numpy as np
import math

class Desizyon:
    def __init__(self):

        file = open("input.txt", "r")
        self.features = list()
        self.dataMatrix = list()

        self.createMatrix(file)
        self.root = self.informationGain()
        self.buildTree(self.root)

    def createMatrix(self, inputFile):

        inputs = inputFile.readlines()
        #print(inputs)
        rows = int(inputs[0].split(" ")[0])
        cols = int(inputs[0].split(" ")[1])
        #print("rows::", rows)
        #print("cols::", cols)

        # SON KOLON LABELS
        self.dataMatrix = np.zeros((rows,cols), dtype=int)
        #print(self.dataMatrix)

        for k in range(1, cols):
            featureName = "F"+str(k)
            self.features.append(featureName)

        print(self.features)
        #x = self.features[0]
        #print(x)

        for i in range(1, rows+1):
            line = inputs[i]
            #print("line number",":",i, line)
            fValues = line.split(" ")
            for j in range(0, len(fValues)):
                if fValues[j].strip() == "T":
                    self.dataMatrix[i-1][j] = 1
                else:
                    self.dataMatrix[i - 1][j] = 0

        #print("AFTER INSERTION::",self.dataMatrix)

    def informationGain(self):

        rows, cols = self.dataMatrix.shape
        featureSize = cols
        probs = np.zeros((4, cols-1),dtype=float)
        sum = 0


        for i in range(0, cols-1):
            for j in range(0, rows):
                if self.dataMatrix[j][i] == 1:
                    sum = sum + 1
                    if self.dataMatrix[j][cols-1] == 1:
                        probs[2][i] = probs[2][i] + 1
            probs[0][i] = sum/rows
            probs[1][i] = sum
            sum = 0


        entropies = list()
        for x in range(0, cols-1):
            probs[3][x] = probs[1][x]-probs[2][x]
            ent = self.entropy(probs[0][x], probs[2][x], probs[3][x])
            print("ENT. FOR FEATURE", x + 1, "::", ent)
            entropies.append(ent)

        #print(probs)

        labelCol = 0
        for n in range(0, rows):
            val = self.dataMatrix[n][cols-1]
            if val == 1:
                labelCol = labelCol + 1
        entForLabel = self.entropy((labelCol/rows), labelCol, rows-labelCol)
        #print("ENTROPY FOR CLASS LABEL", entForLabel)

        infGains = list()
        for elm in range(0, len(entropies)):
            infGain = entForLabel-entropies[elm]
            print("INFO GAIN FOR FEATURE", elm+1, "::", abs(infGain))
            infGains.append(abs(infGain))

        #print(infGains.index(max(infGains)))
        rt = self.features[infGains.index(max(infGains))]
        print("ROOT IS::", rt)
        #print(probs)

        #print(math.log())
        return rt

    def entropy(self, x, y, z):
        total = y+z
        entr = 0
        if y == 0:
            entr = x * (((z / total)*(math.log(z / total, 2))))
        if z == 0:
            entr = x * (((y / total) * (math.log(y / total, 2))))
        else:
            entr = x*(-((y/total)*(math.log(y/total,2)))-((z/total)*(math.log(z/total, 2))))
        return abs(entr)

    def buildTree(self, root):

        rows, cols = self.dataMatrix.shape
        print("TREE:::")
        print("\t\t\t\t", root)
        self.features.remove(root)
        # DIRECT END WITH TRUE
        print("(+)","\t\t","(-)","\t\t", self.features)

        rootIndex = int(root.split("F")[1])-1
        trueCount = 0
        for i in range(0, rows):
            if self.dataMatrix[i][rootIndex] == 1:
                if self.dataMatrix[i][cols-1] == 1:
                    trueCount = trueCount + 1

        probRDT = trueCount / rows

        falseCount = 0


        probRDF = 1 - probRDT

        print("%.3f" % probRDT, "\t\t", "%.3f" % probRDF)

        # DIRECT END WITH FALSE




a = Desizyon()