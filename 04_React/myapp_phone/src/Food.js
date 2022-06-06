const mydata = {

    "myfood": [
        {
            name: "hamberger",
            price: "5000",
            buy: "delivery"
        },
        {
            name: "dosirak",
            price: "6000",
            buy: "take out"
        },
        {
            name: "coffee",
            price: "3000",
            buy: "store"
        }

    ],

    "myphone": [

        {
            name: "galaxy",
            ram: "8",
            touch: "no",
            face: "yes"
        },

        {
            name: "iphone",
            ram: "8",
            touch: "no",
            face: "no"
        },

    ]
}


function Food() {
    return (

        <div>
            <h1> Food Componet </h1>

            {/* JSX ? */}
            {
                mydata.myfood.map((food, i) => {
                    console.log(food.name)
                    return (
                        <div key={i}>
                            name : {food.name} <br />
                            price : {food.price} <br />
                            buy : {food.buy} <hr />
                        </div>
                    );
                })
            }

            <h1>Phone</h1>
            {
                mydata.myphone.map((phone, i) => (

                    <div key={i}>
                        name : {phone.name} <br />
                        ram : {phone.ram} <br />
                        touch : {phone.touch} <br />
                        face : {phone.touch} <hr />
                    </div>
                )

                )}
        </div>

    )
}

export default Food;