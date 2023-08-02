def outer_func():  
    var = 20  # global var
    def inner_func():  
        nonlocal var  
        var = 30   # local var
        print("Value inside the inner function: ", var)  
    inner_func()  
    print("Value inside the outer function: ", var)  
  
outer_func()
