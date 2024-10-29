import math

def hot_and_cold(low,high):
    print("guess 1: ",low)
    print("guess 2: ",high," hoter or colder")
    feedback = input() #this is the feedback
    if feedback == "h":
        return hot_and_cold(math.floor((low + high)//2),high)
    elif feedback == "c":
        return hot_and_cold(low,math.ceil((low + high)//2))
    else:
        return high


# Example usage:
print("Think of a number between 1 and 100.")
secret_number = hot_and_cold(1,100)
print(f"Secret number found: {secret_number}")
