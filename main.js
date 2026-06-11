// ==========================
// 1. JavaScript Basics
// ==========================

console.log("Welcome to the Community Portal");

window.onload = function () {
    alert("Community Portal Loaded Successfully!");
};

// ==========================
// 2. Data Types & Operators
// ==========================

const eventName = "Music Festival";
const eventDate = "15 June 2026";
let availableSeats = 50;

console.log(
    `Event: ${eventName}, Date: ${eventDate}, Seats: ${availableSeats}`
);

// ==========================
// 5. Class & Prototype
// ==========================

class Event {

    constructor(name, category, seats, date) {
        this.name = name;
        this.category = category;
        this.seats = seats;
        this.date = date;
    }
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};

// ==========================
// 6. Arrays
// ==========================

let events = [

    new Event(
        "Music Festival",
        "Music",
        50,
        "2026-06-15"
    ),

    new Event(
        "Sports Meet",
        "Sports",
        30,
        "2026-06-20"
    ),

    new Event(
        "Baking Workshop",
        "Workshop",
        15,
        "2026-06-25"
    )
];

// push()

events.push(
    new Event(
        "Art Show",
        "Art",
        20,
        "2026-07-01"
    )
);

// filter()

const musicEvents =
    events.filter(
        e => e.category === "Music"
    );

console.log(musicEvents);

// map()

const eventTitles =
    events.map(
        e => `Workshop on ${e.name}`
    );

console.log(eventTitles);

// Object.entries()

events.forEach(event => {
    console.log(
        Object.entries(event)
    );
});

// ==========================
// 4. Functions
// ==========================

function addEvent(event) {
    events.push(event);
}

function registerUser(eventName) {

    const event =
        events.find(
            e => e.name === eventName
        );

    try {

        if (!event) {
            throw new Error(
                "Event not found"
            );
        }

        if (event.seats <= 0) {
            throw new Error(
                "No seats available"
            );
        }

        event.seats--;

        renderEvents();

        alert(
            "Registered Successfully!"
        );

    } catch (error) {

        alert(error.message);

    }
}

function filterEventsByCategory(category) {

    return events.filter(
        event =>
            event.category === category
    );
}

// Closure

function registrationCounter() {

    let total = 0;

    return function () {

        total++;

        return total;
    };
}

const countRegistrations =
    registrationCounter();

// ==========================
// 7. DOM Manipulation
// ==========================

function renderEvents() {

    const container =
        document.querySelector(
            "#eventsContainer"
        );

    if (!container) return;

    container.innerHTML = "";

    events.forEach(event => {

        if (
            event.checkAvailability()
        ) {

            const card =
                document.createElement(
                    "div"
                );

            card.className =
                "eventCard";

            card.innerHTML = `
                <h3>${event.name}</h3>
                <p>Category:
                ${event.category}</p>

                <p>Seats:
                ${event.seats}</p>

                <button
                onclick="registerUser(
                '${event.name}')">
                Register
                </button>
            `;

            container.appendChild(
                card
            );
        }
    });
}

// ==========================
// 8. Event Handling
// ==========================

document.addEventListener(
    "DOMContentLoaded",
    () => {

        renderEvents();

        const categoryFilter =
            document.querySelector(
                "#categoryFilter"
            );

        if (categoryFilter) {

            categoryFilter.onchange =
                function () {

                const filtered =
                    filterEventsByCategory(
                        this.value
                    );

                console.log(filtered);
            };
        }

        const search =
            document.querySelector(
                "#searchBox"
            );

        if (search) {

            search.addEventListener(
                "keydown",
                function () {

                    console.log(
                        search.value
                    );
                }
            );
        }
    }
);

// ==========================
// 9. Async Await
// ==========================

fetch(
    "https://jsonplaceholder.typicode.com/posts"
)
.then(response =>
    response.json()
)
.then(data =>
    console.log(
        "Fetched:",
        data.slice(0, 3)
    )
)
.catch(error =>
    console.error(error)
);

async function fetchEvents() {

    try {

        console.log(
            "Loading..."
        );

        const response =
            await fetch(
            "https://jsonplaceholder.typicode.com/posts"
        );

        const data =
            await response.json();

        console.log(data);

    } catch (error) {

        console.error(error);

    }
}

fetchEvents();

// ==========================
// 10. Modern JS
// ==========================

const cloneEvents =
    [...events];

const [firstEvent] =
    cloneEvents;

console.log(firstEvent);

// ==========================
// 11. Forms
// ==========================

const form =
    document.querySelector(
        "#registrationForm"
    );

if (form) {

    form.addEventListener(
        "submit",
        function (event) {

            event.preventDefault();

            const name =
                form.elements["name"]
                ?.value;

            const email =
                form.elements["email"]
                ?.value;

            if (
                !name ||
                !email
            ) {

                alert(
                    "Please fill all fields"
                );

                return;
            }

            console.log(
                "Form Submitted",
                name,
                email
            );
        }
    );
}

// ==========================
// 12. AJAX POST
// ==========================

function submitRegistration() {

    setTimeout(() => {

        fetch(
        "https://jsonplaceholder.typicode.com/posts",
        {
            method: "POST",

            headers: {
                "Content-Type":
                "application/json"
            },

            body:
            JSON.stringify({
                name: "Community User"
            })
        })

        .then(res =>
            res.json()
        )

        .then(data => {

            alert(
                "Registration Sent!"
            );

            console.log(data);
        })

        .catch(error => {

            alert(
                "Submission Failed"
            );

            console.error(error);
        });

    }, 2000);
}