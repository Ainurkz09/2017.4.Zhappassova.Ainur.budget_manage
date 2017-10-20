const gulp = require('gulp');
const concat = require('gulp-concat');
const browserSync = require('browser-sync').create();


// Some pointless comments for our project.

var devMode = false;

gulp.task('css-lib', function() {
    gulp.src("./public/stylesheets/**/*.css")
        .pipe(concat('lib.css'))
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('css', function() {
    gulp.src("./public/stylesheets/main.css")
        .pipe(concat('main.css'))
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.reload({
            stream: true
        }));
});


gulp.task('js-lib', function() {
    gulp.src("./public/javascripts/**/*.js")
        .pipe(concat('scripts-lib.js'))
        .pipe(gulp.dest('./dist/js'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('angular-lib', function() {
    gulp.src(". /public/javascripts/vendors/angular.js")
        .pipe(concat('angular-lib.js'))
        .pipe(gulp.dest('./dist/js'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('js', function() {
    gulp.src("./public/javascripts/*.js")
        .pipe(concat('scripts.js'))
        .pipe(gulp.dest('./dist/js'))
        .pipe(browserSync.reload({
            stream: true
        }));
});
//
gulp.task('html', function() {
    return gulp.src('./public/templates/**/*.html')
        .pipe(gulp.dest('./dist/'))
        .pipe(browserSync.reload({
            stream: true
        }));
});
//
gulp.task('build', function() {
    gulp.start(['angular-lib','js-lib','js','css','html'])
});

gulp.task('browser-sync', function() {
    browserSync.init(null, {
        open: false,
        server: {
            baseDir: 'dist',
        }
    });
});

gulp.task('start', function() {
    devMode = true;
    gulp.start(['build', 'browser-sync']);
    gulp.watch(['./public/stylesheets/*.css'], ['css']);
    gulp.watch(['./public/javascripts/vendor/angular.js'], ['angular-lib']);
    // gulp.watch(['./public/stylesheets/**/*.css'], ['css-lib']);
    gulp.watch(['./public/javascripts/**/*.js'], ['js-lib']);
    gulp.watch(['./public/javascripts/*.js'], ['js']);
    gulp.watch(['./public/views/*.html'], ['html']);
});
