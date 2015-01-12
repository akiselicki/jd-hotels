var app = angular.module("hotelsApp", 
		[
		 "ui.router", 
		 "ngResource", 
		 'datatables'
		 ]);

app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("home");

    $stateProvider
        .state('home', {
            url:'/home',
            templateUrl: URLS.home,
            controller: ''
        })
        .state('login', {
            url:'/login',
            templateUrl: URLS.login,
            controller: ''
        })
        
        //Hotel Routes - Begin
        .state('hotels', {
            url:'/hotels',
            templateUrl: URLS.partialsHotelsList,
            controller: 'HotelCtrl'
        })
        .state('hotels/edit', {
            url:'/hotels/edit/:hotelId',
            templateUrl: URLS.partialsHotelsEdit,
            controller: 'HotelEditCtrl'
        })
        .state('hotels/create', {
            url:'/hotels/create',
            templateUrl: URLS.partialsHotelsCreate,
            controller: 'HotelCtrl'
        })
        //Hotel Routes - End

        //Room Routes - Begin
	    .state('rooms', {
	        url:'/rooms',
	        templateUrl: URLS.partialsRoomsList,
	        controller: 'RoomCtrl'
	    })
	    .state('rooms/edit', {
	        url:'/rooms/edit/:roomId',
	        templateUrl: URLS.partialsRoomsEdit,
	        controller: 'RoomEditCtrl'
	    })
	    .state('rooms/create', {
	        url:'/rooms/create',
	        templateUrl: URLS.partialsRoomsCreate,
	        controller: 'RoomCtrl'
	    });
    	//Room Routes - End

});

// Hotel Controllers - Begin
app.factory("Hotel", function ($resource) {
    return $resource(URLS.hotels, {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});

app.controller("HotelCtrl", function ($scope, Hotel, $resource, $state, DTOptionsBuilder, DTColumnDefBuilder) {
    function init() {
        $scope.getHotels();
    }

    $scope.getHotels = function () {
        $scope.hotels = Hotel.query();
    };

    $scope.dtOptions = DTOptionsBuilder.newOptions().withPaginationType('full_numbers').withDisplayLength(10);
    $scope.dtColumnDefs = [
        DTColumnDefBuilder.newColumnDef(0),
        DTColumnDefBuilder.newColumnDef(1),
        DTColumnDefBuilder.newColumnDef(2),
        DTColumnDefBuilder.newColumnDef(3).notSortable()
    ];
    
    $scope.deleteHotel = function (hotel) {
        return hotel.$delete({}, function () {
            $scope.hotels.splice($scope.hotels.indexOf(hotel), 1);
        });
    };

    $scope.createHotel = function () {
        var hotel = new Hotel($scope.hotel);
        hotel.$save({}, function() {
            $state.transitionTo("hotels");
        });
    };

    init();
});

app.controller("HotelEditCtrl", function ($scope, Hotel, $state, $stateParams) {
    function init() {
        $scope.hotel = Hotel.get({id:$stateParams.hotelId})
    }

    $scope.updateHotel = function() {
       var hotel = new Hotel($scope.hotel);
       hotel.$update().then(function() {
           $state.transitionTo("hotels");
       }) ;
    }
    init();
});
//Hotel Controllers - End

//Room Controllers - Begin
app.factory("Room", function ($resource) {
    return $resource(URLS.rooms, {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("RoomByHotel", function ($resource) {
    return $resource(URLS.roomsByHotel, {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});

app.controller("RoomCtrl", function ($scope, Room, RoomByHotel, Hotel, $resource, $state, DTOptionsBuilder, DTColumnDefBuilder) {
    function init() {    	
        //$scope.getRooms();
    	$scope.getRoomsByHotel();
        $scope.getHotels();
    }

    $scope.getRooms = function () {
        $scope.rooms = Room.query();
    };

    $scope.getRoomsByHotel = function () {
//        $scope.rooms = RoomByHotel.query({id:1});
    	$scope.rooms = RoomByHotel.query();
    };
    
	$scope.getHotels = function () {
	    $scope.hotels = Hotel.query();
	};

    $scope.dtOptions = DTOptionsBuilder.newOptions().withPaginationType('full_numbers').withDisplayLength(10);
    $scope.dtColumnDefs = [
        DTColumnDefBuilder.newColumnDef(0),
        DTColumnDefBuilder.newColumnDef(1),
        DTColumnDefBuilder.newColumnDef(2),
        DTColumnDefBuilder.newColumnDef(3),
        DTColumnDefBuilder.newColumnDef(4).notSortable()
    ];
    
    
    $scope.deleteRoom = function (room) {
        return room.$delete({}, function () {
            $scope.rooms.splice($scope.rooms.indexOf(room), 1);
        });
    };

    $scope.createRoom = function () {
        var room = new RoomByHotel($scope.room);
        room.$save({}, function() {
            $state.transitionTo("rooms");
        });
    };

    init();
});

app.controller("RoomEditCtrl", function ($scope, Room, Hotel, $state, $stateParams) {
    function init() {
        $scope.room = Room.get({id:$stateParams.roomId})
        $scope.getHotels();
    }

    $scope.getHotels = function () {
        $scope.hotels = Hotel.query();
    };
    
    $scope.updateRoom = function() {
       var room = new Room($scope.room);
       room.$update().then(function() {
           $state.transitionTo("rooms");
       }) ;
    }
    init();
});
//Room Controllers - End
