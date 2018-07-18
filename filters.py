from PIL import Image

def pt1():
    ask = input('Would you like to insert a photo?  ')
    ask_response = ['yes', 'yeah', 'ok', 'sure']

    img = Image.open('blonde.jpg')
    img.show()
pt1()

def pt2():
    choice = input('Press 1 to make the image black and white, 2 for Obamicon.  ')
    if choice == '1':
        img = Image.open('blonde.jpg').convert('L')
        img.show()
    elif choice == '2':
        img = Image.open('blonde.jpg')
        colorpixels = list(img.getdata())
        list_length=len(colorpixels)

        darkBlue = (0, 51, 76)
        red = (217, 26, 33)
        lightBlue = (112, 150, 158)
        yellow = (252, 227, 166)

        for i in range(list_length):
        	#print(i)
        	redpart = colorpixels[i][0]
        	bluepart = colorpixels[i][1]
        	greenpart = colorpixels[i][2]
        	sum = redpart + bluepart + greenpart

        	#print(sum)
        	if sum < 182:
        		colorpixels[i] = darkBlue
        	elif sum >= 182 and sum < 364:
        		colorpixels[i] = red
        	elif sum >= 364 and sum< 546:
        		colorpixels[i] = lightBlue
        	else:
        		colorpixels[i]= yellow


        img.putdata(colorpixels)
        img.show()
pt2()
