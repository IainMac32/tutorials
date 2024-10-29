def IdleFinder(list):
    highestIdle = 0
    highestNotIdle = 0

    #sort list
    for i in range(len(list) - 1):
        for j in range(i + 1,len(list)):
            if list[i][0] > list[j][0]:
                list [i],list[j] = list[j],list[i]

    for i in range(len(list)):
        #compares the start and finish time of one task
        if (list[i][1] - list[i][0]) > highestNotIdle:
            highestNotIdle = list[i][1] - list[i][0]

        #compares the end of a task with the start time of the next task
        if i < len(list) - 1 and ((list[i + 1][0] - list[i][1]) > highestIdle):
            highestIdle = list[i + 1][0] - list[i][1]

        #if two operations overlap and the second one is longer 
        if i < len(list) - 1 and list[i + 1][0] > list[i][0] and list[i + 1][0] < list[i][1]:
            if list[i + 1][1] > list[i][1]:
                #if difference between start of first and end of second is largest non idle
                if (list[i + 1][1] - list[i][0]) > highestNotIdle:
                    highestNotIdle = list[i + 1][1] - list[i][0]

    
    return [highestIdle,highestNotIdle]


list = [(1,5),(15,16),(6,10),(100,150),(111,1000)]
print(IdleFinder(list))
