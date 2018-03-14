FROM ingensi/oracle-jdk
ADD sample-middleware/build/libs/ /sample-middleware
RUN mkdir -p /sample-middleware/logs
RUN mkdir -p /sample-middleware/plugins
ADD sample-modules/bootstrap/build/libs/ /sample-middleware/plugins
ADD sample-modules/localization/build/libs/ /sample-middleware/plugins
ADD sample-modules/oauth/build/libs/ /sample-middleware/plugins
ADD sample-modules/patient/build/libs/ /sample-middleware/plugins
ADD sample-modules/stock/build/libs/ /sample-middleware/plugins
CMD /sample-middleware/sample-middleware.sh
